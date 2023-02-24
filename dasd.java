package org.duckdb;

import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

public class DuckDBResultSet implements ResultSet {

	private DuckDBPreparedStatement stmt;
	private DuckDBResultSetMetaData meta;

	private ByteBuffer result_ref;
	private DuckDBVector[] current_chunk;
	private int chunk_idx = 0;
	private boolean finished = false;
	private boolean was_null;
	private boolean was_null;

	public DuckDBResultSet(DuckDBPreparedStatement stmt, DuckDBResultSetMetaData meta, ByteBuffer result_ref) {
		this.stmt = stmt;
		this.result_ref = result_ref;
		this.meta = meta;
		current_chunk = DuckDBNative.duckdb_jdbc_fetch(result_ref);
		if (current_chunk.length == 0) {
			finished = true;
		}
	}

	public Statement getStatement() throws SQLException {
		if (isClosed()) {
			throw new SQLException("ResultSet was closed");
		}
		return stmt;
	}

	public ResultSetMetaData getMetaData() throws SQLException {
		if (isClosed()) {
			throw new SQLException("ResultSet was closed");
		}
		return meta;
	}

	public boolean next() throws SQLException {
		if (isClosed()) {
			throw new SQLException("ResultSet was closed");
		}
		if (finished) {
			return false;
		}
		chunk_idx++;
		if (chunk_idx > current_chunk[0].length) {
			current_chunk = DuckDBNative.duckdb_jdbc_fetch(result_ref);
			chunk_idx = 1;
		}
		if (current_chunk.length == 0) {
			finished = true;
			return false;
		}
		return true;
	}

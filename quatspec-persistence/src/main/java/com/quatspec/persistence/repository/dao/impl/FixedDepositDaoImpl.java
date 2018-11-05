package com.quatspec.persistence.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.quatspec.persistence.dao.FixedDepositDao;
import com.quatspec.persistence.domain.FixedDepositAccount;

@Repository(value = "fixedDepositDao")
public class FixedDepositDaoImpl implements FixedDepositDao {
	private static Logger logger = LogManager.getLogger(FixedDepositDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public int createFixedDeposit(final FixedDepositAccount fdd) {
		final String sql = "insert into bank_account (account_id, creation_date, amount, tenure, active, email, account_type) "
				+ "values(?,?, ?, ?, ?, ?, ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, new String[] { "fixed_deposit_id" });
				ps.setInt(1, fdd.getBankAccountId());
				ps.setDate(2, new java.sql.Date(fdd.getCreationDate().getTime()));
				ps.setInt(3, fdd.getFdAmount());
				ps.setInt(4, fdd.getTenure());
				ps.setString(5, fdd.getActive());
				ps.setString(6, fdd.getEmail());
				ps.setString(7, fdd.getAccountType());
				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().intValue();
	}

	public FixedDepositAccount getFixedDeposit(final long fixedDepositId) {
		final String sql = "select * from bank_account where fixed_deposit_id = :fixedDepositId";
		SqlParameterSource namedParameters = new MapSqlParameterSource("fixedDepositId", fixedDepositId);
		return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, new RowMapper<FixedDepositAccount>() {
			public FixedDepositAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
				FixedDepositAccount fdd = new FixedDepositAccount();
				fdd.setActive(rs.getString("active"));
				fdd.setBankAccountId(rs.getInt("account_id"));
				fdd.setFdAmount(rs.getInt("amount"));
				fdd.setCreationDate(rs.getDate("creation_date"));
				fdd.setFixedDepositId(rs.getString("fixed_deposit_id"));
				fdd.setTenure(rs.getInt("tenure"));
				fdd.setEmail(rs.getString("email"));
				return fdd;
			}
		});
	}

	public List<FixedDepositAccount> getInactiveFixedDeposits() {
		final String sql = "select * from bank_account where account_type = 'FD' and active = 'N'";
		List<FixedDepositAccount> fdds = jdbcTemplate.query(sql, new RowMapper<FixedDepositAccount>() {
			public FixedDepositAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
				FixedDepositAccount fdd = new FixedDepositAccount();
				fdd.setActive(rs.getString("active"));
				fdd.setBankAccountId(rs.getInt("account_id"));
				fdd.setFdAmount(rs.getInt("amount"));
				fdd.setCreationDate(rs.getDate("creation_date"));
				fdd.setFixedDepositId(rs.getString("fixed_deposit_id"));
				fdd.setTenure(rs.getInt("tenure"));
				fdd.setEmail(rs.getString("email"));
				return fdd;
			}
		});
		return fdds;
	}

	public void setFixedDepositsAsActive(List<FixedDepositAccount> fds) {
		for (FixedDepositAccount fd : fds) {
			logger.info("Processing fixed deposit with ID : " + fd.getFixedDepositId());
			jdbcTemplate
					.update("update fixed_deposit_details set active = 'Y' where fixed_deposit_id = ?",
							fd.getFixedDepositId());
		}
	}

	public List<FixedDepositAccount> findFixedDepositsByBankAccount(long bankAccountId) {
		final String sql = "select * from bank_account where account_id = " + bankAccountId;
		List<FixedDepositAccount> fdds = jdbcTemplate.query(sql, new RowMapper<FixedDepositAccount>() {
			public FixedDepositAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
				FixedDepositAccount fdd = new FixedDepositAccount();
				fdd.setActive(rs.getString("active"));
				fdd.setBankAccountId(rs.getInt("account_id"));
				fdd.setFdAmount(rs.getInt("amount"));
				fdd.setCreationDate(rs.getDate("creation_date"));
				fdd.setFixedDepositId(rs.getString("fixed_deposit_id"));
				fdd.setTenure(rs.getInt("tenure"));
				fdd.setEmail(rs.getString("email"));
				return fdd;
			}
		});
		return fdds;
	}

}

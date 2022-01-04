package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.TransferDTO;
import com.techelevator.tenmo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.List;

public interface AccountDao {

    Account getAccountBalance(String username);

    void processTransfer(TransferDTO transferDTO);

    TransferDTO[] listTransfers(long userId);


}

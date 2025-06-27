package com.ccp.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ccp.entities.Account;
import com.ccp.entities.Address;
import com.ccp.entities.Customer;
import com.ccp.entities.Statement;
import com.ccp.repositories.IStatementRepository;
@SpringBootTest
public class IStatementServiceLayerTest {
	@Autowired
	private StatementService serv;
	@MockBean
	private IStatementRepository rep;
	@Test
	void addStatementTest() {
		Statement statement = new Statement(1,1500,LocalDate.of(2023, 2, 12),LocalDate.of(20023, 2, 27),true );
		when(rep.save(statement)).thenReturn(statement);
		assertEquals(statement,serv.addStatement(statement));
	}
	@Test
	void getAllStatementsTest() {
		when(rep.getAllStatements()).thenReturn(Stream.of(new Statement(1,1500,LocalDate.of(2023, 2, 12),LocalDate.of(20023, 2, 27),true))
				.collect(Collectors.toList()));
		assertEquals(1,serv.getAllStatements().size());
		
	}
	@Test
	void getAllStatementIdTest() {
		int id =1;
		doReturn(Optional.of(new Statement(1,1500,LocalDate.of(2023, 2, 12),LocalDate.of(20023, 2, 27),true))).when(rep).getById((long) id);
	}
	@Test
	public void updateStatementTest()
	{
//		Statement statement = new Statement(1,1500,LocalDate.of(2023, 2, 12),LocalDate.of(20023, 2, 27),true);
//		when(rep.existsById(statement.getStatementId())).thenReturn(true);
//		when(rep.save(statement)).thenReturn(statement);
//		assertEquals(statement, serv.updateStatement(statement.getStatementId(),statement));
		int id = 1;
		doReturn(Optional.of(new Statement(1,1500,LocalDate.of(2023, 2, 12),LocalDate.of(20023, 2, 27),true))).when(rep).getById((long) id);
		
	}
	@Test
	public void RemoveStatementId_Success() {
		long id = 1;
		Statement statement = new Statement();
		statement.setStatementId(1);
		
	}
	

}

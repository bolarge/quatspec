/*package com.quatspec.middleware.job;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.quatspec.api.model.IBankAccount;
import com.quatspec.middleware.consumer.FixedDepositMessageListener;
import com.quatspec.service.financial.FinancialPaymentsService;

public class FixedDepositProcessorJob {
	
private static Logger logger = LogManager.getLogger(FixedDepositMessageListener.class);
	
	@Autowired @Qualifier("financialServiceRegistry")
	private FinancialPaymentsService financialPaymentsService;

	@Autowired
	private transient JavaMailSender mailSender;

	@Autowired
	@Qualifier("requestProcessedTemplate")
	private transient SimpleMailMessage simpleMailMessage;

	private List<IBankAccount> getInactiveFixedDeposits() {
		return (List<IBankAccount>) financialPaymentsService.getBankService().getInactiveBankAccounts();
	}

	public void sendEmail() throws AddressException, MessagingException {
		List<IBankAccount> inactiveFds = getInactiveFixedDeposits();
		for (IBankAccount fd : inactiveFds) {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
			mimeMessageHelper.setTo(fd.getUser().getEmail());
			mimeMessageHelper.setSubject(simpleMailMessage.getSubject());
			mimeMessageHelper.setText(simpleMailMessage.getText());
			mailSender.send(mimeMessage);
		}
		financialPaymentsService.getBankService().deActivateBankAccount(inactiveFds);
	}
}*/
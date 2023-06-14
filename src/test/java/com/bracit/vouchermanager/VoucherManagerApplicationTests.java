package com.bracit.vouchermanager;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.bracit.vouchermanager.common.api.Response;
import com.bracit.vouchermanager.model.VoucherMetaData;
import com.bracit.vouchermanager.model.VoucherModel;
import com.bracit.vouchermanager.model.VoucherRequest;
import com.bracit.vouchermanager.model.VoucherResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import com.bracit.vouchermanager.service.VoucherManagerService;
import com.bracit.vouchermanager.service.VoucherManagerServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class VoucherManagerApplicationTests {

	@Test
	void contextLoads() {
	}


	@Test
	public void sendVoucherToEsb() throws JsonProcessingException {
		VoucherManagerService<VoucherRequest,VoucherResponse> voucherManagerService = new VoucherManagerServiceImpl<>();
		VoucherModel voucherModel = getVoucherModel();
		VoucherRequest voucherRequest = VoucherRequest.builder().voucherModel(voucherModel).build();
		VoucherMetaData voucherMetaData = getVoucherMetaData();
		Response<VoucherResponse> response = voucherManagerService.sendVoucherToMfDirectly(voucherRequest,voucherMetaData);
		assertEquals("SUCCESS",response.getCode());
	}

	private VoucherMetaData getVoucherMetaData(){
		VoucherMetaData metaData =  VoucherMetaData.builder()
				.rootUrl("https://erpdevelopment.brac.net")
				.apiEndPoint("/nodef/accountingApi/autoVoucher")
				.finKey("5d0a4a85-df7a-siapi-bits-93eb-145f6a9902ae")
				.build();
		HttpHeaders httpHeaders =new HttpHeaders();
		httpHeaders.set("key",metaData.getFinKey());
		metaData.setHttpHeaders(httpHeaders);
		return metaData;
	}

	private VoucherModel getVoucherModel(){
		VoucherModel voucherModel = VoucherModel.builder()
				.eventId(1)
				.appOrganizationBranch(2l)
				.projectId(1l)
				.referenceId(2l)
				.paymentType("sfd")
				.transactionDate("2023-06-11 00:00:00")
				.refTransactionNo("wds")
				.particulars("scds")
				.createdBy(1l)
				.payToName("adss")
				.receivedFrom("sds")
				.bankAccountId(1l)
				.accPaymentSubType(1l)
				.transactionDocumentNo("adssc")
				.transactionDocumentDate("2023-06-11 00:00:00")
				.build();
		return voucherModel;
	}

}

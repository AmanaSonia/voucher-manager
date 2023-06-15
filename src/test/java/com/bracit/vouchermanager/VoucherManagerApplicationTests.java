package com.bracit.vouchermanager;
import com.bracit.vouchermanager.model.*;
import com.bracit.vouchermanager.service.VoucherPostingServicesTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.bracit.vouchermanager.common.api.Response;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.bracit.vouchermanager.service.VoucherManagerService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SuppressWarnings("unchecked")
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class VoucherManagerApplicationTests {

	@Autowired
	private VoucherManagerService voucherManagerService;

	@Autowired
	private VoucherPostingServicesTest voucherPostingServicesTest;


	@Test
	void contextLoads() {
	}

	//@Test
	//@Order(1)
	public void sendVoucherToEsbAsync() throws JsonProcessingException {
		VoucherModel voucherModel = voucherPostingServicesTest.getEsbVoucherModel();
		VoucherRequest voucherRequest = VoucherRequest.builder().voucherModel(voucherModel).build();
			VoucherMetaData voucherMetaData = voucherPostingServicesTest.getVoucherMetaDataEsb("http://10.42.53.185:8090/async","nodef/accountingApi/autoVoucher");
		Response response = voucherManagerService.sendVoucherToEsbAsync(voucherRequest,voucherMetaData);
		assertEquals("200",response.getCode());
	}

	//@Test
	//@Order(2)
	public void sendVoucherToEsbSync() throws JsonProcessingException {
		VoucherModel voucherModel = voucherPostingServicesTest.getEsbVoucherModel();
		VoucherRequest voucherRequest = VoucherRequest.builder().voucherModel(voucherModel).build();
		VoucherMetaData voucherMetaData = voucherPostingServicesTest.getVoucherMetaDataEsb("http://10.42.53.185:8090/sync","nodef/accountingApi/autoVoucher");
		Response<VoucherResponse> response = voucherManagerService.sendVoucherToEsbSync(voucherRequest,voucherMetaData);
		assertEquals("200",response.getCode());
	}


	//@Test
	//@Order(3)
	public void sendVoucherToMfDirectLy() throws JsonProcessingException {
		VoucherModel voucherModel = voucherPostingServicesTest.getEsbVoucherModel();
		VoucherRequest voucherRequest = VoucherRequest.builder().voucherModel(voucherModel).build();
		VoucherMetaData voucherMetaData = voucherPostingServicesTest.getVoucherMetaDataEsb("https://erpdevelopment.brac.net","nodef/accountingApi/autoVoucher");
		Response response = voucherManagerService.sendVoucherToMfDirectly(voucherRequest,voucherMetaData);
		assertEquals("200",response.getCode());
	}

	//@Test
	//@Order(4)
	public void flushVoucher() throws JsonProcessingException {
		VoucherModel voucherModel = voucherPostingServicesTest.getEsbVoucherModel();
		FlushVoucherModel flushVoucherModel = FlushVoucherModel.builder()
				.tracerId("tid12345")
				.voucherModel(voucherModel).build();
		flushVoucherModel.setVoucherModel(voucherModel);;
		ApiRequestMetaData apiRequestMetaData = voucherPostingServicesTest.getApiRequestData();
		Response response = voucherManagerService.flushVoucher(flushVoucherModel,apiRequestMetaData);
		assertEquals("200",response.getCode());
	}


}

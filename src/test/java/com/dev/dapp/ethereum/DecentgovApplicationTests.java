package com.dev.dapp.ethereum;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dev.dapp.ethereum.service.Web3jService;

/**
 * The Class DecentgovApplicationTests.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DecentgovApplicationTests {

	/** The web3j sample service. */
	@Autowired
	private Web3jService web3jSampleService;

	/**
	 * Test get client version.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testGetClientVersion() throws IOException {
		Assert.assertTrue(web3jSampleService.getClientVersion().startsWith("Geth/"));
	}

}

package com.dev.dapp.ethereum.service;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;
import org.web3j.utils.Numeric;

import com.dev.dapp.ethereum.exception.DAppException;
import com.dev.dapp.ethereum.smartcontractwrappers.Counter;

/**
 * The Class Web3jService.
 */
@Service
public class Web3jService {

	/** The web3j. */
	@Autowired
	private Web3j web3j;

	/** The contract. */
	private Counter contract;

	/**
	 * Deploy contract.
	 *
	 * @param walletFile
	 *            the wallet file
	 * @param password
	 *            the password
	 * @return the contract address
	 * @throws Exception
	 *             the exception
	 */
	public String deployContract(File walletFile, String password) throws Exception {

		Credentials credentials = WalletUtils.loadCredentials(password, walletFile);

		contract = Counter.deploy(web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT).send();
		System.out.println("deployer's address : " + credentials.getAddress());
		System.out.println("contract address : " + contract.getContractAddress());

		return contract.getContractAddress();
	}

	/**
	 * Fetch contract.
	 *
	 * @param walletFile
	 *            the wallet file
	 * @param password
	 *            the password
	 * @param contractAddress
	 *            the contract address
	 * @throws Exception
	 *             the exception
	 */
	public void fetchContract(File walletFile, String password, String contractAddress) throws Exception {
		Credentials credentials = WalletUtils.loadCredentials(password, walletFile);
		contract = Counter.load(contractAddress, web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);
		System.out.println("deployer's address : " + credentials.getAddress());

	}

	/**
	 * Gets the counter value.
	 *
	 * @return the counter value
	 * @throws Exception
	 *             the exception
	 */
	public BigInteger getCounterValue() throws Exception {
		return contract.getCount().send();
	}

	/**
	 * Increase counter value.
	 *
	 * @return the transaction hash
	 * @throws Exception
	 *             the exception
	 */
	public String increaseCounterValue() throws Exception {
		TransactionReceipt receipt = contract.incCounter().send();
		System.out.println("GAS used : " + receipt.getGasUsed());
		System.out.println("Tx hash : " + receipt.getTransactionHash());
		if (!isStatusOk(receipt)) {
			throw new DAppException("Something went wrong while executing ethereum transaction!");
		}
		return receipt.getTransactionHash();
	}

	/**
	 * Decrease counter value.
	 *
	 * @return the transaction hash
	 * @throws Exception
	 *             the exception
	 */
	public String decreaseCounterValue() throws Exception {
		TransactionReceipt receipt = contract.decCounter().send();
		System.out.println("GAS used : " + receipt.getGasUsed());
		System.out.println("Tx hash : " + receipt.getTransactionHash());
		if (!isStatusOk(receipt)) {
			throw new DAppException("Something went wrong while executing ethereum transaction!");
		}
		return receipt.getTransactionHash();
	}

	/**
	 * Gets the client version.
	 *
	 * @return the web3j client version
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public String getClientVersion() throws IOException {
		Web3ClientVersion web3ClientVersion = web3j.web3ClientVersion().send();
		return web3ClientVersion.getWeb3ClientVersion();
	}

	/**
	 * Checks if is status ok.
	 *
	 * @param receipt
	 *            the receipt
	 * @return true, if is status ok
	 */
	private boolean isStatusOk(TransactionReceipt receipt) {
		BigInteger statusQuantity = Numeric.decodeQuantity(receipt.getStatus());
		return BigInteger.ONE.equals(statusQuantity);
	}

}
package com.dev.dapp.ethereum.smartcontractwrappers;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>
 * Auto generated code.
 * <p>
 * <strong>Do not modify!</strong>
 * <p>
 * Please use the <a href="https://docs.web3j.io/command_line.html">web3j
 * command line tools</a>, or the
 * org.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen
 * module</a> to update.
 *
 * <p>
 * Generated with web3j version 3.5.0.
 */
public class Counter extends Contract {
	private static final String BINARY = "608060405234801561001057600080fd5b50600060018190558054600160a060020a031916331790556102fe806100376000396000f3006080604052600436106100615763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663206fd5af811461006657806322aacad51461007d578063a87d942c14610092578063f851a440146100b9575b600080fd5b34801561007257600080fd5b5061007b6100f7565b005b34801561008957600080fd5b5061007b610220565b34801561009e57600080fd5b506100a76102b0565b60408051918252519081900360200190f35b3480156100c557600080fd5b506100ce6102b6565b6040805173ffffffffffffffffffffffffffffffffffffffff9092168252519081900360200190f35b60005473ffffffffffffffffffffffffffffffffffffffff16331461017d57604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601f60248201527f6f6e6c792061646d696e2063616e20696e63726561736520636f756e74657200604482015290519081900360640190fd5b60015460001061021457604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152603460248201527f43616e277420646563726561736520696620636f756e7465722069732065717560448201527f616c20746f206f72206c657373207468616e2030000000000000000000000000606482015290519081900360840190fd5b60018054600019019055565b60005473ffffffffffffffffffffffffffffffffffffffff1633146102a657604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601f60248201527f6f6e6c792061646d696e2063616e20696e63726561736520636f756e74657200604482015290519081900360640190fd5b6001805481019055565b60015490565b60005473ffffffffffffffffffffffffffffffffffffffff16815600a165627a7a723058204658290d77ba7b047c17ac2325ad525d115ba0b59406344ed0460d99d65926470029";

	public static final String FUNC_DECCOUNTER = "decCounter";

	public static final String FUNC_INCCOUNTER = "incCounter";

	public static final String FUNC_GETCOUNT = "getCount";

	public static final String FUNC_ADMIN = "admin";

	protected Counter(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice,
			BigInteger gasLimit) {
		super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
	}

	protected Counter(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice,
			BigInteger gasLimit) {
		super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
	}

	public RemoteCall<TransactionReceipt> decCounter() {
		final Function function = new Function(FUNC_DECCOUNTER, Arrays.<Type>asList(),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteCall<TransactionReceipt> incCounter() {
		final Function function = new Function(FUNC_INCCOUNTER, Arrays.<Type>asList(),
				Collections.<TypeReference<?>>emptyList());
		return executeRemoteCallTransaction(function);
	}

	public RemoteCall<BigInteger> getCount() {
		final Function function = new Function(FUNC_GETCOUNT, Arrays.<Type>asList(),
				Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {
				}));
		return executeRemoteCallSingleValueReturn(function, BigInteger.class);
	}

	public RemoteCall<String> admin() {
		final Function function = new Function(FUNC_ADMIN, Arrays.<Type>asList(),
				Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {
				}));
		return executeRemoteCallSingleValueReturn(function, String.class);
	}

	public static RemoteCall<Counter> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice,
			BigInteger gasLimit) {
		return deployRemoteCall(Counter.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
	}

	public static RemoteCall<Counter> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice,
			BigInteger gasLimit) {
		return deployRemoteCall(Counter.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
	}

	public static Counter load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice,
			BigInteger gasLimit) {
		return new Counter(contractAddress, web3j, credentials, gasPrice, gasLimit);
	}

	public static Counter load(String contractAddress, Web3j web3j, TransactionManager transactionManager,
			BigInteger gasPrice, BigInteger gasLimit) {
		return new Counter(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
	}
}
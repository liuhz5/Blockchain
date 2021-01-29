package SupplyChain;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.web3j.abi.FunctionReturnDecoder;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Address;
import org.fisco.bcos.web3j.abi.datatypes.Bool;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.Utf8String;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint256;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple1;
import org.fisco.bcos.web3j.tuples.generated.Tuple2;
import org.fisco.bcos.web3j.tuples.generated.Tuple3;
import org.fisco.bcos.web3j.tx.Contract;
import org.fisco.bcos.web3j.tx.TransactionManager;
import org.fisco.bcos.web3j.tx.gas.ContractGasProvider;
import org.fisco.bcos.web3j.tx.txdecode.TransactionDecoder;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.fisco.bcos.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version null.
 */
@SuppressWarnings("unchecked")
public class SupplyChain extends Contract {
    public static final String[] BINARY_ARRAY = {"608060405234801561001057600080fd5b50611050806100206000396000f300608060405260043610610083576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680630267b5be1461008857806321974999146100cb5780632813d19d1461011857806328bdcde8146101f1578063438fb76e14610298578063563ce4c6146103225780637577962f14610365575b600080fd5b34801561009457600080fd5b506100c9600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506103be565b005b3480156100d757600080fd5b50610116600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610566565b005b34801561012457600080fd5b50610143600480360381019080803590602001909291905050506108bb565b60405180806020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828103825284818151815260200191508051906020019080838360005b838110156101b557808201518184015260208101905061019a565b50505050905090810190601f1680156101e25780820380516001836020036101000a031916815260200191505b50935050505060405180910390f35b3480156101fd57600080fd5b5061021c600480360381019080803590602001909291905050506109a6565b604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828152602001935050505060405180910390f35b3480156102a457600080fd5b506102d9600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610a1f565b604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060405180910390f35b34801561032e57600080fd5b50610363600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610a75565b005b34801561037157600080fd5b506103bc600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190803515159060200190929190505050610e27565b005b60008060009150600090505b60008054905081101561051d578273ffffffffffffffffffffffffffffffffffffffff166000828154811015156103fd57fe5b906000526020600020906003020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614156104755760008181548110151561045a57fe5b90600052602060002090600302016002015482039150610510565b8273ffffffffffffffffffffffffffffffffffffffff1660008281548110151561049b57fe5b906000526020600020906003020160010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16141561050f576000818154811015156104f857fe5b906000526020600020906003020160020154820191505b5b80806001019150506103ca565b81600260008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002081905550505050565b600080600091505b6000805490508210156108b4573373ffffffffffffffffffffffffffffffffffffffff166000838154811015156105a157fe5b906000526020600020906003020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614801561066157508373ffffffffffffffffffffffffffffffffffffffff1660008381548110151561061757fe5b906000526020600020906003020160010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16145b156108a75760008360008481548110151561067857fe5b906000526020600020906003020160020154031415610843578190505b60016000805490500381101561083e576000600182018154811015156106b757fe5b906000526020600020906003020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166000828154811015156106f857fe5b906000526020600020906003020160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060006001820181548110151561075957fe5b906000526020600020906003020160010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1660008281548110151561079a57fe5b906000526020600020906003020160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000600182018154811015156107fb57fe5b90600052602060002090600302016002015460008281548110151561081c57fe5b9060005260206000209060030201600201819055508080600101915050610695565b6108a6565b60008360008481548110151561085557fe5b9060005260206000209060030201600201540311156108a1578260008381548110151561087e57fe5b9060005260206000209060030201600201600082825403925050819055506108b4565b6108b5565b5b818060010192505061056e565b5b50505050565b6001818154811015156108ca57fe5b9060005260206000209060020201600091509050806000018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156109765780601f1061094b57610100808354040283529160200191610976565b820191906000526020600020905b81548152906001019060200180831161095957829003601f168201915b5050505050908060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905082565b6000818154811015156109b557fe5b90600052602060002090600302016000915090508060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16908060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16908060020154905083565b600080610a2b836103be565b82600260008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205491509150915091565b6000806000806000610a85610fd6565b339550869450600093505b600080549050841015610e1e578573ffffffffffffffffffffffffffffffffffffffff16600085815481101515610ac357fe5b906000526020600020906003020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415610e1157600084815481101515610b2057fe5b906000526020600020906003020160010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169250600091505b600080549050821015610e10578273ffffffffffffffffffffffffffffffffffffffff16600083815481101515610b8c57fe5b906000526020600020906003020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16148015610c4c57508473ffffffffffffffffffffffffffffffffffffffff16600083815481101515610c0257fe5b906000526020600020906003020160010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16145b15610e0357600082815481101515610c6057fe5b906000526020600020906003020160020154600085815481101515610c8157fe5b90600052602060002090600302016002016000828254039250508190555085816000019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff168152505084816020019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff1681525050600082815481101515610d1e57fe5b9060005260206000209060030201600201548160400181815250506000819080600181540180825580915050906001820390600052602060002090600302016000909192909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550604082015181600201555050505b8180600101925050610b59565b5b8380600101945050610a90565b50505050505050565b610e2f610fd6565b8115610e8c57610e3e336103be565b6000600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020541015610e8b57610fd0565b5b33816000019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff168152505083816020019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff1681525050828160400181815250506000819080600181540180825580915050906001820390600052602060002090600302016000909192909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550604082015181600201555050505b50505050565b606060405190810160","405280600073ffffffffffffffffffffffffffffffffffffffff168152602001600073ffffffffffffffffffffffffffffffffffffffff1681526020016000815250905600a165627a7a72305820e6a9cb0effc1d7e4dd6695a0a06490283e04de09c19e67a70c06a40fdcaebb600029"};

    public static final String BINARY = String.join("", BINARY_ARRAY);

    public static final String[] ABI_ARRAY = {"[{\"constant\":false,\"inputs\":[{\"name\":\"adr\",\"type\":\"address\",\"type0\":null,\"indexed\":false}],\"name\":\"GetDebt\",\"outputs\":[],\"type\":\"function\",\"payable\":false,\"stateMutability\":\"nonpayable\"},{\"constant\":false,\"inputs\":[{\"name\":\"receive\",\"type\":\"address\",\"type0\":null,\"indexed\":false},{\"name\":\"amount\",\"type\":\"uint256\",\"type0\":null,\"indexed\":false}],\"name\":\"PayDebt\",\"outputs\":[],\"type\":\"function\",\"payable\":false,\"stateMutability\":\"nonpayable\"},{\"constant\":true,\"inputs\":[{\"name\":\"\",\"type\":\"uint256\",\"type0\":null,\"indexed\":false}],\"name\":\"companies\",\"outputs\":[{\"name\":\"name\",\"type\":\"string\",\"type0\":null,\"indexed\":false},{\"name\":\"adr\",\"type\":\"address\",\"type0\":null,\"indexed\":false}],\"type\":\"function\",\"payable\":false,\"stateMutability\":\"view\"},{\"constant\":true,\"inputs\":[{\"name\":\"\",\"type\":\"uint256\",\"type0\":null,\"indexed\":false}],\"name\":\"bills\",\"outputs\":[{\"name\":\"company_from\",\"type\":\"address\",\"type0\":null,\"indexed\":false},{\"name\":\"company_to\",\"type\":\"address\",\"type0\":null,\"indexed\":false},{\"name\":\"amount\",\"type\":\"uint256\",\"type0\":null,\"indexed\":false}],\"type\":\"function\",\"payable\":false,\"stateMutability\":\"view\"},{\"constant\":true,\"inputs\":[{\"name\":\"adr\",\"type\":\"address\",\"type0\":null,\"indexed\":false}],\"name\":\"GetBill\",\"outputs\":[{\"name\":\"\",\"type\":\"address\",\"type0\":null,\"indexed\":false},{\"name\":\"\",\"type\":\"uint256\",\"type0\":null,\"indexed\":false}],\"type\":\"function\",\"payable\":false,\"stateMutability\":\"view\"},{\"constant\":false,\"inputs\":[{\"name\":\"adr\",\"type\":\"address\",\"type0\":null,\"indexed\":false}],\"name\":\"transfer_bill\",\"outputs\":[],\"type\":\"function\",\"payable\":false,\"stateMutability\":\"nonpayable\"},{\"constant\":false,\"inputs\":[{\"name\":\"receive\",\"type\":\"address\",\"type0\":null,\"indexed\":false},{\"name\":\"amount\",\"type\":\"uint256\",\"type0\":null,\"indexed\":false},{\"name\":\"is_bank\",\"type\":\"bool\",\"type0\":null,\"indexed\":false}],\"name\":\"create_bill\",\"outputs\":[],\"type\":\"function\",\"payable\":false,\"stateMutability\":\"nonpayable\"},{\"constant\":false,\"inputs\":[],\"name\":null,\"outputs\":null,\"type\":\"constructor\",\"payable\":false,\"stateMutability\":\"nonpayable\"}]"};

    public static final String ABI = String.join("", ABI_ARRAY);

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_GETDEBT = "GetDebt";

    public static final String FUNC_PAYDEBT = "PayDebt";

    public static final String FUNC_COMPANIES = "companies";

    public static final String FUNC_BILLS = "bills";

    public static final String FUNC_GETBILL = "GetBill";

    public static final String FUNC_TRANSFER_BILL = "transfer_bill";

    public static final String FUNC_CREATE_BILL = "create_bill";

    @Deprecated
    protected SupplyChain(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(getBinary(), contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected SupplyChain(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(getBinary(), contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected SupplyChain(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(getBinary(), contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected SupplyChain(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(getBinary(), contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static String getBinary() {
        return BINARY;
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
    }

    public RemoteCall<TransactionReceipt> GetDebt(String adr) {
        final Function function = new Function(
                FUNC_GETDEBT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(adr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void GetDebt(String adr, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_GETDEBT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(adr)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String GetDebtSeq(String adr) {
        final Function function = new Function(
                FUNC_GETDEBT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(adr)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getGetDebtInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_GETDEBT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> PayDebt(String receive, BigInteger amount) {
        final Function function = new Function(
                FUNC_PAYDEBT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(receive), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void PayDebt(String receive, BigInteger amount, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_PAYDEBT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(receive), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String PayDebtSeq(String receive, BigInteger amount) {
        final Function function = new Function(
                FUNC_PAYDEBT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(receive), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, BigInteger> getPayDebtInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_PAYDEBT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<String, BigInteger>(

                (String) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue()
                );
    }

    public RemoteCall<Tuple2<String, String>> companies(BigInteger param0) {
        final Function function = new Function(FUNC_COMPANIES, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}));
        return new RemoteCall<Tuple2<String, String>>(
                new Callable<Tuple2<String, String>>() {
                    @Override
                    public Tuple2<String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<String, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue());
                    }
                });
    }

    public RemoteCall<Tuple3<String, String, BigInteger>> bills(BigInteger param0) {
        final Function function = new Function(FUNC_BILLS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple3<String, String, BigInteger>>(
                new Callable<Tuple3<String, String, BigInteger>>() {
                    @Override
                    public Tuple3<String, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, String, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteCall<Tuple2<String, BigInteger>> GetBill(String adr) {
        final Function function = new Function(FUNC_GETBILL, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(adr)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple2<String, BigInteger>>(
                new Callable<Tuple2<String, BigInteger>>() {
                    @Override
                    public Tuple2<String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<String, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> transfer_bill(String adr) {
        final Function function = new Function(
                FUNC_TRANSFER_BILL, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(adr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void transfer_bill(String adr, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_TRANSFER_BILL, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(adr)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String transfer_billSeq(String adr) {
        final Function function = new Function(
                FUNC_TRANSFER_BILL, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(adr)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getTransfer_billInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_TRANSFER_BILL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> create_bill(String receive, BigInteger amount, Boolean is_bank) {
        final Function function = new Function(
                FUNC_CREATE_BILL, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(receive), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(amount), 
                new org.fisco.bcos.web3j.abi.datatypes.Bool(is_bank)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void create_bill(String receive, BigInteger amount, Boolean is_bank, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_CREATE_BILL, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(receive), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(amount), 
                new org.fisco.bcos.web3j.abi.datatypes.Bool(is_bank)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String create_billSeq(String receive, BigInteger amount, Boolean is_bank) {
        final Function function = new Function(
                FUNC_CREATE_BILL, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(receive), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(amount), 
                new org.fisco.bcos.web3j.abi.datatypes.Bool(is_bank)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple3<String, BigInteger, Boolean> getCreate_billInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_CREATE_BILL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple3<String, BigInteger, Boolean>(

                (String) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue(), 
                (Boolean) results.get(2).getValue()
                );
    }

    @Deprecated
    public static SupplyChain load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new SupplyChain(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static SupplyChain load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SupplyChain(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static SupplyChain load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new SupplyChain(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static SupplyChain load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new SupplyChain(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<SupplyChain> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SupplyChain.class, web3j, credentials, contractGasProvider, getBinary(), "");
    }

    public static RemoteCall<SupplyChain> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SupplyChain.class, web3j, transactionManager, contractGasProvider, getBinary(), "");
    }

    @Deprecated
    public static RemoteCall<SupplyChain> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SupplyChain.class, web3j, credentials, gasPrice, gasLimit, getBinary(), "");
    }

    @Deprecated
    public static RemoteCall<SupplyChain> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SupplyChain.class, web3j, transactionManager, gasPrice, gasLimit, getBinary(), "");
    }
}

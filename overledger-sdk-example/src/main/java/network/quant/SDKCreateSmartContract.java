package network.quant;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import network.quant.api.Account;
import network.quant.api.DLT;
import network.quant.api.NETWORK;
import network.quant.api.SCFunctionType;
import network.quant.essential.DefaultOverledgerSDK;
import network.quant.essential.dto.OverledgerTransactionRequest;
import network.quant.essential.dto.OverledgerTransactionResponse;
import network.quant.ethereum.EthereumAccount;
import network.quant.ethereum.experimental.dto.*;
import network.quant.util.DltSequenceRequest;
import network.quant.util.SequenceRequest;
import network.quant.util.SequenceResponse;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class SDKCreateSmartContract {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        DefaultOverledgerSDK.setDefaultLocation("./src/main/resources/context.properties");
        DefaultOverledgerSDK sdk = DefaultOverledgerSDK.newInstance();

        String smartContractDemoCode = "0x60806040523480156200001157600080fd5b5060405162000e6e38038062000e6e833981810160405260e08110156200003757600080fd5b81019080805190602001909291908051906020019092919080519060200190929190805160405193929190846401000000008211156200007657600080fd5b838201915060208201858111156200008d57600080fd5b8251866001820283011164010000000082111715620000ab57600080fd5b8083526020830192505050908051906020019080838360005b83811015620000e1578082015181840152602081019050620000c4565b50505050905090810190601f1680156200010f5780820380516001836020036101000a031916815260200191505b5060405260200180519060200190929190805160405193929190846401000000008211156200013d57600080fd5b838201915060208201858111156200015457600080fd5b82518660018202830111640100000000821117156200017257600080fd5b8083526020830192505050908051906020019080838360005b83811015620001a85780820151818401526020810190506200018b565b50505050905090810190601f168015620001d65780820380516001836020036101000a031916815260200191505b5060405260200180516040519392919084640100000000821115620001fa57600080fd5b838201915060208201858111156200021157600080fd5b82518660208202830111640100000000821117156200022f57600080fd5b8083526020830192505050908051906020019060200280838360005b83811015620002685780820151818401526020810190506200024b565b50505050905001604052505050866000806101000a81548160ff0219169083151502179055508560018190555084600260006101000a81548161ffff021916908361ffff1602179055508360039080519060200190620002ca9291906200034b565b5082600460006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508160059080519060200190620003249291906200034b565b5080600690805190602001906200033d929190620003d2565b5050505050505050620004da565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106200038e57805160ff1916838001178555620003bf565b82800160010185558215620003bf579182015b82811115620003be578251825591602001919060010190620003a1565b5b509050620003ce91906200047f565b5090565b82805482825590600052602060002090601f016020900481019282156200046c5791602002820160005b838211156200043b57835183826101000a81548160ff0219169083151502179055509260200192600101602081600001049283019260010302620003fc565b80156200046a5782816101000a81549060ff02191690556001016020816000010492830192600103026200043b565b505b5090506200047b9190620004a7565b5090565b620004a491905b80821115620004a057600081600090555060010162000486565b5090565b90565b620004d791905b80821115620004d357600081816101000a81549060ff021916905550600101620004ae565b5090565b90565b61098480620004ea6000396000f3fe608060405234801561001057600080fd5b50600436106100ea5760003560e01c8063970123261161008c578063d41ed3c711610066578063d41ed3c7146103de578063ea48e4bf1461040c578063f0befa001461042e578063fa7a4955146104b1576100ea565b8063970123261461034c578063a74006821461037c578063c6ca37fa1461039a576100ea565b80632d5ccf02116100c85780632d5ccf02146101915780632dc6f2581461020a5780632f91be48146102505780636c40848f146102d3576100ea565b8063114fd062146100ef5780632204251114610121578063288e94c814610147575b600080fd5b61011f6004803603602081101561010557600080fd5b81019080803561ffff16906020019092919050505061052a565b005b61012961054a565b604051808261ffff1661ffff16815260200191505060405180910390f35b61014f610562565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b610208600480360360208110156101a757600080fd5b81019080803590602001906401000000008111156101c457600080fd5b8201836020820111156101d657600080fd5b803590602001918460018302840111640100000000831117156101f857600080fd5b909192939192939050505061058c565b005b6102366004803603602081101561022057600080fd5b81019080803590602001909291905050506105a2565b604051808215151515815260200191505060405180910390f35b6102586105d8565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561029857808201518184015260208101905061027d565b50505050905090810190601f1680156102c55780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b61034a600480360360208110156102e957600080fd5b810190808035906020019064010000000081111561030657600080fd5b82018360208201111561031857600080fd5b8035906020019184600183028401116401000000008311171561033a57600080fd5b909192939192939050505061067a565b005b61037a6004803603602081101561036257600080fd5b81019080803515159060200190929190505050610690565b005b6103846106ac565b6040518082815260200191505060405180910390f35b6103dc600480360360208110156103b057600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506106b6565b005b61040a600480360360208110156103f457600080fd5b81019080803590602001909291905050506106fa565b005b610414610704565b604051808215151515815260200191505060405180910390f35b61043661071a565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561047657808201518184015260208101905061045b565b50505050905090810190601f1680156104a35780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b610528600480360360208110156104c757600080fd5b81019080803590602001906401000000008111156104e457600080fd5b8201836020820111156104f657600080fd5b8035906020019184602083028401116401000000008311171561051857600080fd5b90919293919293905050506107bc565b005b80600260006101000a81548161ffff021916908361ffff16021790555050565b6000600260009054906101000a900461ffff16905090565b6000600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905090565b81816005919061059d9291906107d2565b505050565b6000600682815481106105b157fe5b90600052602060002090602091828204019190069054906101000a900460ff169050919050565b606060058054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156106705780601f1061064557610100808354040283529160200191610670565b820191906000526020600020905b81548152906001019060200180831161065357829003601f168201915b5050505050905090565b81816003919061068b9291906107d2565b505050565b806000806101000a81548160ff02191690831515021790555050565b6000600154905090565b80600460006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b8060018190555050565b60008060009054906101000a900460ff16905090565b606060038054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156107b25780601f10610787576101008083540402835291602001916107b2565b820191906000526020600020905b81548152906001019060200180831161079557829003601f168201915b5050505050905090565b8181600691906107cd929190610852565b505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061081357803560ff1916838001178555610841565b82800160010185558215610841579182015b82811115610840578235825591602001919060010190610825565b5b50905061084e91906108fa565b5090565b82805482825590600052602060002090601f016020900481019282156108e95791602002820160005b838211156108ba578335151583826101000a81548160ff021916908315150217905550926020019260010160208160000104928301926001030261087b565b80156108e75782816101000a81549060ff02191690556001016020816000010492830192600103026108ba565b505b5090506108f6919061091f565b5090565b61091c91905b80821115610918576000816000905550600101610900565b5090565b90565b61094c91905b8082111561094857600081816101000a81549060ff021916905550600101610925565b5090565b9056fea265627a7a7231582011a3367b2aa1d8689c3400f319a4a3f4b9e1304e8cd90316adb2a26729b3e61b64736f6c63430005110032";
        String partyAEthereumPrivateKey = "e352ad01a835ec50ba301ed7ffb305555cbf3b635082af140b3864f8e3e443d3"; //should have 0x in front

        Account ethAcnt = EthereumAccount.getInstance(NETWORK.ROPSTEN, new BigInteger(partyAEthereumPrivateKey, 16), BigInteger.ZERO);
        sdk.addAccount("ethereum", ethAcnt);

        String partyAEthereumAddress = "0x650A87cfB9165C9F4Ccc7B971D971f50f753e761";

        List<ContractArgument> inputValues = new ArrayList<ContractArgument>() {
            {
                add(ContractArgument.builder()
                        .type(ContractInputTypeOptions.BOOL)
                        .value("true")
                        .build());

                add(ContractArgument.builder()
                        .type(ContractInputTypeOptions.INT)
                        .selectedIntegerLength(EthereumUintIntOptions.B256)
                        .value("5")
                        .build());

                add(ContractArgument.builder()
                        .type(ContractInputTypeOptions.UINT)
                        .selectedIntegerLength(EthereumUintIntOptions.B16)
                        .value("33")
                        .build());

//                TODO: not sure this is not working...
/*                add(ContractArgument.builder()
                        .type(ContractInputTypeOptions.BYTES)
                        .selectedBytesLength(EthereumBytesOptions.B32)
                        //.value("00000000000000000000000000000000")  //0x68656c6c6f on java script apparently it represents Hello
                        .value("0x68656c6c6f")
                        .build());
*/
                add(ContractArgument.builder()
                        .type(ContractInputTypeOptions.STRING)
                        .value("Hello")
                        .build());


                add(ContractArgument.builder()
                        .type(ContractInputTypeOptions.ADDRESS)
                        .value("0x650A87cfB9165C9F4Ccc7B971D971f50f753e761")
                        .build());

                add(ContractArgument.builder()
                        .type(ContractInputTypeOptions.STRING)
                        .value("Hi_there!")
                        .build());

                add(ContractArgument.builder()
                        .type(ContractInputTypeOptions.BOOLEAN_ARRAY)
                        .value("{true, false, true}")
                        .build());


            }
        };

        SequenceRequest sequenceRequest = new SequenceRequest(Arrays.asList(new DltSequenceRequest(DLT.ethereum, partyAEthereumAddress)));
        SequenceResponse sequenceResponse = sdk.getSequence(sequenceRequest);
        log.info("sequence: " + sequenceResponse.getDltData().get(0).getSequence());

        //function name is not needed for constructor
        //toAddress must be empty for a contractDeploy transaction
        TransactionEthereumRequest createContractRequest = TransactionEthereumRequest.trxEthereumReqBuilder()
                .dlt(DLT.ethereum.name())
                .sequence(sequenceResponse.getDltData().get(0).getSequence().longValue())  //must be an integer >= 0
                .fromAddress(partyAEthereumAddress)
                .toAddress("")

                .code(smartContractDemoCode)
                .funcName("")
                .functionType(SCFunctionType.CONSTRUCTOR_WITH_PARAMETERS)
                .inputValues(inputValues)

                .feeLimit(BigInteger.valueOf(4000000l))
                .fee(BigInteger.valueOf(8000000000l))
                .amount(BigInteger.valueOf(0l))  //must be an integer >= 0

                .build();

        OverledgerTransactionRequest overledgerTransactionRequest = OverledgerTransactionRequest.builder()
                .mappId(OverledgerContext.MAPP_ID)
                .dltData(Arrays.asList(createContractRequest)).build();

        OverledgerTransactionResponse overledgerTransaction = null;
        try {
            overledgerTransaction = (OverledgerTransactionResponse) sdk.createSmartContract(overledgerTransactionRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("create smart contract response: " + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(overledgerTransaction));
    }
}
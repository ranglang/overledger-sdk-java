package network.quant.ethereum.experimental.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContractArgument {

    ContractInputTypeOptions type;
    String value;
    EthereumUintIntOptions selectedIntegerLength;
    EthereumBytesOptions selectedBytesLength;
    Long selectedArrayLength;

}
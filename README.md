# Counter DApp

We will create a very simple decentralized application running on ethereum network.

## Install Solidity

We will use [Solidity](https://solidity.readthedocs.io) to write smart contract. You can download solidity compiler from their [github](https://github.com/ethereum/solidity/releases).
 
For ubnutu:
 
    sudo add-apt-repository ppa:ethereum/ethereum
    sudo apt-get update
    sudo apt-get install solc

Now we will write our first smart contract :nerd_face:
  
Check [`Counter.sol`](https://gist.github.com/devender-yadav/2cddc65d751e92f939fbd20a32af3868#file-counter-sol) file for a simple counter smart contract.
  
 
 ## Compile Solidity code
 
Since we already installed Solidity, lets start compiling our smart contract code.

    solc counter.sol --bin --abi --optimize -o .
    
It will create `Counter.bin` and `Counter.abi` files in the current directory. 
 
`Counter.bin` is compiled code and `Counter.abi` is _application binary interface_ file. 
 
[ABI](https://en.wikipedia.org/wiki/Application_binary_interface) is a list of contract's function and arguments. It will help in calling actual machine coded functions. 
 
## Install Web3j
 
We will use [web3j](https://github.com/web3j/web3j) to create smart contract java wrapper and to interact with ethereum. You can download it from their [github](https://github.com/web3j/web3j/releases).
![web3j](https://raw.githubusercontent.com/web3j/web3j/master/docs/source/images/web3j_network.png)
 
 Now we will create smart contract java wrapper:
 
 _Assuming `Counter.bin` and `Counter.abi` are located in `/abc/` directory._
 
    web3j solidity generate /abc/Counter.bin /abc/Counter.abi -o /abc/ -p com.dev.blockchain
    
_here `-p` is package name in java class._



 

# Counter DApp

It's a simple counter decentralized application. Anyone can read it's counter value and only contract publisher can increase/decrease it. Check [wiki](https://github.com/devender-yadav/counter-dapp/wiki) to know about the various tools used. 

## How to use

### Clone project and create the executable war file

    git clone https://github.com/devender-yadav/counter-dapp.git
    
    cd counter-dapp
    
    mvn clean install
    
`counterdapp-1.0-SNAPSHOT.war` will be created in the target folder.

### Start Dapp
    
    java -jar target/counterdapp-1.0-SNAPSHOT.war
    
  
 The application will run on **localhost:8080**
 

### Create Ethereum wallet

1. You can use https://www.myetherwallet.com/
2. You can use web3j itself

       ./web3j wallet create
       
**How to get test ether**

For ropsten testnet - http://faucet.ropsten.be:3001/
 
 
## Ethereum endpoint configuration

Edit `web3j.client-address` property in [application.properties](https://github.com/devender-yadav/counter-dapp/blob/master/src/main/resources/application.properties) as per your ethereum client.


-----------


_P.S. This is just an experimental demo DApp. Feel free to edit it_ :smile:

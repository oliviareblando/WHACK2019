import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class PropertyChain {
    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static int difficulty = 5;
    

        public static Boolean isChainValid() {
        Block currentBlock; 
        Block previousBlock;
        String hashTarget = new String(new char[difficulty]).replace('\0', '0');
        
        //loop through blockchain to check hashes:
        for(int i=1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);
            //compare registered hash and calculated hash:
            if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
                System.out.println("Current Hashes not equal");         
                return false;
            }
            //compare previous hash and registered previous hash
            if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
            //check if hash is solved
            if(!currentBlock.hash.substring( 0, difficulty).equals(hashTarget)) {
                System.out.println("This block hasn't been mined");
                return false;
            }
        }
        return true;
    }

        public static void main(String[] args) {
        //create owner
        Person owner = new Person("Julia", "hello");
        //create house
        House Wellesley = new House("Wellesley", 400, owner, 4);
        //add house to blockchain
        Block a = Wellesley.getGenesis(); 
        blockchain.add(a);
        //mine block
        System.out.println("Trying to Mine block 1... ");
        blockchain.get(0).mineBlock(difficulty);
        //create person
        Person lian = new Person("Lian", "hi");
        //person buys tokens, add to bc
        Block b = lian.buyTokens(2, owner, blockchain.get(blockchain.size()-1).hash);
        blockchain.add(b);
        //mine block
        System.out.println("Trying to Mine block 2... ");
        blockchain.get(1).mineBlock(difficulty);
        //valid bc
        System.out.println("\nBlockchain is Valid: " + isChainValid());
        //json
        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println("\nThe block chain: ");
        System.out.println(blockchainJson);
        
        //create another person
        
        //person buy from other person
        
        //add our blocks to the blockchain ArrayList:
        
        // blockchain.add(new Block("Hi im the first block", "0", ));
        // System.out.println("Trying to Mine block 1... ");
        // blockchain.get(0).mineBlock(difficulty);
        
        // blockchain.add(new Block("Yo im the second block",blockchain.get(blockchain.size()-1).hash));
        // System.out.println("Trying to Mine block 2... ");
        // blockchain.get(1).mineBlock(difficulty);
        
        // blockchain.add(new Block("Hey im the third block",blockchain.get(blockchain.size()-1).hash));
        // System.out.println("Trying to Mine block 3... ");
        // blockchain.get(2).mineBlock(difficulty); 
        
        // System.out.println("\nBlockchain is Valid: " + isChainValid());
        
        // String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        // System.out.println("\nThe block chain: ");
        // System.out.println(blockchainJson);
    }
    

}
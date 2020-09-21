
/**
 *
 */
public class House
{
    private String name;
    private double value;
    private Person owner;
    private int tokensLeft;
    private final int TOKENTOTAL;
    //private int tokenValue;
    private Block genesisBlock;
    private double percentOwnership;

    /**
     * Constructor for objects of class House being initially created.
     */
    public House(String nm, double intialValue, Person ogOwner, int totalShares)
    {
        name = nm;
        this.value = intialValue;
        this.owner = ogOwner;
        owner.setTokens(totalShares);
        tokensLeft = totalShares;
        genesisBlock = new Block ("Property " +nm+ " Created", "000", this);
        TOKENTOTAL = totalShares;
        percentOwnership = findPercentOwnership();
    }
    
    public double findPercentOwnership(){
        return (1/ TOKENTOTAL);
    }
    
    public Block getGenesis(){
        return genesisBlock;
    }
    
    /**
     * When the value of the house increases a block is created and variables are updated
     */
    public Block increaseValue(double increase, String previousHash)
    {
        value += increase;
        String msg = "The new house value is " + String.valueOf(value);
        Block houseBlock = new Block(msg, previousHash, this);
        return houseBlock;
    }

    /**
     * When the value of the house decreases a block is created and variables are updated
     */
    public Block decreaseValue(double decrease, String previousHash)
    {
        value -= decrease;
        String msg = "The new house value is " + String.valueOf(value);
        Block houseBlock = new Block(msg, previousHash, this);
        return houseBlock;
    }

    public double getValue(){
        return value;
    }

    public Person getOwner(){
        return owner;
    }
}

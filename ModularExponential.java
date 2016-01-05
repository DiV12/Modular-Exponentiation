package modularexponential;

import java.math.BigInteger;

/**
 *
 * @author DIV
 */
public class ModularExponential {
    public static BigInteger ModExponential(BigInteger baseValue, BigInteger powerValue, BigInteger modularValue){
        BigInteger result = null;
        BigInteger oneVal= new BigInteger("1");
        BigInteger zeroVal= new BigInteger("0");
        BigInteger twoVal= new BigInteger("2");
        BigInteger baseVal = baseValue;
        BigInteger powerVal = powerValue;
        BigInteger modVal = modularValue;
        if(powerVal.equals(zeroVal)){
            return oneVal;
        }
        else if((powerVal.mod(twoVal)).equals(zeroVal)){
            BigInteger tempVal = ModExponential(baseVal, (powerVal.divide(twoVal)), modVal);
            result = ((tempVal.multiply(tempVal)).mod(modVal));
        }
        else{
            result = (((baseVal).multiply(ModExponential(baseVal,(powerVal.subtract(oneVal)),modVal))).mod(modVal));
        }
        return result; 
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BigInteger base = new BigInteger("8888"); 
        BigInteger power = new BigInteger("200000"); 
        BigInteger modular = new BigInteger("12345"); 
        BigInteger modexpoResult = ModExponential(base, power, modular);
        System.out.println("Boom, the modular exponential value is:" +" " + modexpoResult);
    }
    
}

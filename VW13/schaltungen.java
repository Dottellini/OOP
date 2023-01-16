import java.util.Random;

enum Bit { ZERO, ONE; }

interface Gate {
    Gate process(Bit... input);
    Bit[] getOutput();
}

abstract class OberGate {
    Bit[] resultBit = new Bit[1];
    int counter = 0;

    public Bit[] getOutput() {
        for(int i = 0; i < resultBit.length; i++) {
            if(resultBit[i] == null) {
               resultBit[i] = new Random().nextInt(100) > 75 ? Bit.ONE : Bit.ZERO;
           }
        }
        return resultBit;
    }
}

class AND extends OberGate implements Gate {
    public Gate process(Bit... input) {
        Bit[] helper = new Bit[resultBit.length + 1];
        for(int i = 0; i < resultBit.length; i++) {
            helper[i] = resultBit[i];
        }
        resultBit = helper;

        resultBit[counter] = Bit.ONE;

        for(int i = 0; i < input.length; i++) {
            if(input[i] == Bit.ZERO) {
                resultBit[counter] = Bit.ZERO;
                break;
            }
        }

        

        counter++;
        return this;
    }
}


class NOR extends OberGate implements Gate{
    public Gate process(Bit... input) {
        Bit[] helper = new Bit[resultBit.length + 1];
        for(int i = 0; i < resultBit.length; i++) {
            helper[i] = resultBit[i];
        }
        resultBit = helper;

        resultBit[counter] = Bit.ONE;

        for(int i = 0; i < input.length; i++) {
            if(input[i] == Bit.ONE) {
                resultBit[counter] = Bit.ZERO;
                break;
            }
        }

        counter++;
        return this;
    }
}


class FlipFlop extends OberGate implements Gate{
    Bit[] resultBit = new Bit[2]; //q, not_q

    //Bitarray random befüllen
    FlipFlop() {
        for(int i = 0; i < resultBit.length; i++) {
            if(resultBit[i] == null) {
               resultBit[i] = new Random().nextInt(100) > 75 ? Bit.ONE : Bit.ZERO;
           }
        }    
    }

    public Gate process(Bit... input) {
        if(input.length != 2) throw new IllegalArgumentException("es müssen 2 Bits eingegeben werden");
        if(input[0] == Bit.ONE && input[1] == Bit.ONE) throw new IllegalArgumentException("Es dürfen nicht beide Bits ONE sein");

        Bit s = new NOR().process(input[0], resultBit[1]).getOutput()[0];
        resultBit[1] = new NOR().process(input[1], s).getOutput()[0];
        resultBit[0] = new NOR().process(input[0], resultBit[1]).getOutput()[0];
        
        return this;
    }
}
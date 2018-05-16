package ex.io.impl;

import ex.io.interfaces.ConsoleIO;
import org.springframework.stereotype.Component;

@Component
public class ConsoleIOImpl implements ConsoleIO {
    @Override
    public void write(String line) {
        System.out.println(line);
        //throw new UnsupportedOperationException("I am not implemented yet!");
    }
}

package factory;

import java.io.IOException;

public class ConcreteCreator extends Creator {

	@Override
	public Product factoryMethod(String typ) throws IOException {
		
		if("csv".equals(typ)) {
			return new ConcreteProductA();
		}
		else {
			return new ConcreteProductAB();
		}
	}

}

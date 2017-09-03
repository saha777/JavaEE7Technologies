package number.generators.impls;

import annotations.Loggable;
import annotations.ThirteenDigits;
import number.generators.NumberGenerator;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

@Alternative
@ThirteenDigits
public class MockGenerator implements NumberGenerator {

    @Inject
    private Logger logger;

    @Loggable
    public String generateNumber() {
        String mock = "MOCK-"+Math.abs(new Random().nextInt());
        logger.info("Сгенерирован новый MOCK: "+ mock);
        return mock;
    }
}

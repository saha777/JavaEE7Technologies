package number.generators.impls;

import annotations.EightDigits;
import annotations.Loggable;
import number.generators.NumberGenerator;

import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

@EightDigits
public class IssnGenerator implements NumberGenerator {

    @Inject
    private Logger logger;

    @Loggable
    public String generateNumber() {
        String issn = "8-"+Math.abs(new Random().nextInt());
        logger.info("Сгенерирован новый ISSN: "+ issn);
        return issn;
    }

}

//Users/Shahin/Desktop/all_pooled/computing/CODING/JavaExercises/simpleButImportant
/*
Based on an answer given in Stackoverflow by user 'adarshr', the following
demonstrates three ways you can initialise a constant member field, be
it static or non-static.
*/

public class StaticConstantInitialisation {

  public static void main(String[] args) {

    System.out.println("static constant, initialised via static block = " + StaticFinal.STATIC_CONSTANT);
    FinalOnlyConstructor foc = new FinalOnlyConstructor();
    System.out.println("non-static constant, initialised via constructor = " + foc.NONSTATIC_CONSTANT);
    FinalOnlyBlock fob = new FinalOnlyBlock();
    System.out.println("non-static constrant, initialised via block = " + fob.NONSTATIC_CONSTANT);

  }

}

//#1 initialising a static constant via a static block.
class StaticFinal {

  protected static final int STATIC_CONSTANT;

  static {

    STATIC_CONSTANT = 100;

  }

}

//#2 initialising a non-static constant via the constructor
class FinalOnlyConstructor {

  protected final int NONSTATIC_CONSTANT;

  public FinalOnlyConstructor() {

    NONSTATIC_CONSTANT = 200;

  }

}

//#3 initialising a non-static constant via a block
class FinalOnlyBlock {

  protected final int NONSTATIC_CONSTANT;

  {

    NONSTATIC_CONSTANT = 300;

  }

}

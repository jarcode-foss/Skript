package com.w00tmast3r.skript.lang;

public interface SyntaxUnit {

    /**
     * Called after the constructor of this unit during parse time.
     *
     * @param initData the initialization data of the unit
     * @return true if the unit was initialized successfully
     */
    boolean init(Initializer initData);

}

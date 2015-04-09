package com.w00tmast3r.skript.lang;

import com.w00tmast3r.skript.lang.scope.Scope;
import com.w00tmast3r.skript.util.Syntax;

public class EffectImpl implements Effect {

    static {
        Syntax.data("", EffectImpl::new);
    }

    @Override
    public boolean init(Initializer initData) {

        return false;  // TODO Auto generated method stub
    }

    @Override
    public Scope getParent() {
        return null;  // TODO Auto generated method stub
    }

    @Override
    public void setParent(Scope scope) {
        // TODO Auto generated method stub
    }

    @Override
    public void setEnclosingParent(Scope scope) {
        // TODO Auto generated method stub
    }

    @Override
    public Traversable getNext() {
        return null;  // TODO Auto generated method stub
    }

    @Override
    public void setNext(Traversable traversable) {
        // TODO Auto generated method stub
    }
}

package com.dev.GoFCreationalPatterns.AbstractFactory;
class HonoluluConcreteSoupFactory extends AbstractSoupFactory {
    public HonoluluConcreteSoupFactory() {
        factoryLocation = "Honolulu";
    }
    public ClamChowder makeClamChowder() {
       return new HonoluluClamChowder();
    }
    public FishChowder makeFishChowder() {
       return new HonoluluFishChowder();
    }
}
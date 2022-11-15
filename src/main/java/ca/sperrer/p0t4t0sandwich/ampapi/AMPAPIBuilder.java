package ca.sperrer.p0t4t0sandwich.ampapi;

class AMPAPIBuilder {
    private String _baseURI = "";
    public AMPAPIBuilder() { }

    public AMPAPI buildAMPAPI() {
        return new AMPAPI(_baseURI);
    }
    public AMPAPIBuilder baseURI(String _baseURI) {
        this._baseURI = _baseURI;
        return this;
    }
}
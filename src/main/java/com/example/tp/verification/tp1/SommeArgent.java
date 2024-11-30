package com.example.tp.verification.tp1;

public class SommeArgent {

    private int quantite;
    private String unite;

    public SommeArgent(int amount, String currency) {
        quantite = amount;
        unite = currency;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getUnite() {
        return unite;
    }

    public SommeArgent add(SommeArgent m) {
        return new SommeArgent(getQuantite()+m.getQuantite(), getUnite());
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof SommeArgent) {
            return ((SommeArgent) o).getUnite().equals(getUnite()) && ((SommeArgent) o).getQuantite() == getQuantite();
        } else {
            return false;
        }
    }

}

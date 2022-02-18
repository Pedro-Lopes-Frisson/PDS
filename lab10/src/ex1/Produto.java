package ex1;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

public class Produto implements biddingSystem {
  protected static int Identifier = 0;
  int ID;
  String Nome;
  String descricao;
  double basePrice;
  State state;
  double highestBid;
  Observer highestBider;
  protected ArrayList<Observer> observers = new ArrayList<>();
  
  protected Produto( Builder b ) {
    this.ID = Identifier;
    this.Nome = b.Nome;
    this.basePrice = b.basePrice;
    this.state = b.state;
    this.descricao = b.descricao;
  }
  
  public void setDescricao( String descricao ) {
    this.descricao = descricao;
  }
  
  @Override public boolean equals( Object o ) {
    if ( this == o ) return true;
    if ( o == null || getClass() != o.getClass() ) return false;
    Produto produto = (Produto) o;
    return ID == produto.ID && Double.compare( produto.basePrice, basePrice ) == 0 &&
      descricao.equals( produto.descricao ) && state == produto.state;
  }
  
  public int getID() {
    return ID;
  }
  
  @Override public int hashCode() {
    return Objects.hash( ID, descricao, basePrice, state );
  }
  
  @Override public String toString() {
    return "Produto{" +
      "ID=" + ID +
      ", descricao='" + descricao + '\'' +
      ", basePrice=" + basePrice +
      ", state=" + state +
      '}';
  }
  
  void attachObserver( Observer o ) {
    if ( ! observers.contains( o ) ) { this.observers.add( o ); }
    notifyAll( "Atached observer" + o );
  }
  
  protected void notify( Observer o, String message ) {
    o.update( message );
  }
  
  @Override public boolean registerbid( Observer o, double ammount ) {
    if ( this.state.equals( State.LEILAO ) ) {
      if ( ammount > this.highestBid ) {
        highestBid = ammount;
        highestBider = o;
        notifyAll( String.format( "%s placed a bet. Bet Value-> %f", o.name, ammount ) );
        return true;
      }
      else { return false; }
    }
    return false;
  }
  
  
  private void notifyAll( String format ) {
    observers.forEach( o -> this.notify( o, format ) );
  }
  
  
  @Override public void initAuction( long time ) {
    this.state = State.LEILAO;
    this.notifyAll( "Changed my state to Leilao" );
    Thread t = new Thread( new TimerProduct( time, this ) );
    t.start();
  }
  
  public String getDescricao() {
    return descricao;
  }
  
  public String getName() {
    return Nome;
  }
  
  protected class TimerProduct implements Runnable {
    long Time;
    Produto p;
    
    TimerProduct( long Time, Produto p ) {
      this.Time = Time;
      this.p = p;
    }
    
    @Override public void run() {
      try {
        Thread.sleep( this.Time * 1000 );
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      
      if ( highestBid > basePrice ) {
        p.state = State.VENDAS;
        p.notifyAll(  "Auction for " + getName() + " timed out." + "Observer " + highestBider.name + "won the " +
          "auction for" + p.toString() );
      }
      else {
        state = State.STOCK;
        p.notifyAll( "Auction for " + getName() + " timed out. There were no bids surprassing the base price" );
      }
    }
    
  }
  
  public static class Builder {
    private final String Nome;
    private final double basePrice;
    private State state = State.STOCK;
    private String descricao;
    
    public Builder( String nome, double basePrice ) {
      Nome = nome;
      this.basePrice = basePrice;
    }
    
    public Builder addDescricao( String d ) {
      this.descricao = d;
      return this;
    }
    
    public Produto build() {
      return new Produto( this );
    }
  }
}
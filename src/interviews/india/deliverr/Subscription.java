package interviews.india.deliverr;

class Subscription {
  public Subscription() {}
  public Subscription(int id, int customerId, int monthlyPriceInDollars) {
    this.id = id;
    this.customerId = customerId;
    this.monthlyPriceInDollars = monthlyPriceInDollars;
  }

  public int id;
  public int customerId;
  public int monthlyPriceInDollars;
}

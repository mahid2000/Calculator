package calculator;

/**
 * Wrapper class to hide contained Entry Values.
 * 
 * @author Mahid
 */
public class Entry {

  // Initialise private data types.
  private Float number;
  private Symbol other;
  private Type type;
  private String str;

  /**
   * Create an entry with a given Value.
   * 
   * @param v the value
   */
  public Entry(float v) {
    this.number = v;
  }

  /**
   * Create an entry with a given Symbol.
   * 
   * @param w A symbol
   */
  public Entry(Symbol w) {
    this.other = w;
  }

  /**
   * Create an entry with a given Type.
   * 
   * @param t A Type
   */
  public Entry(Type t) {
    this.type = t;
  }

  /**
   * Create an entry with a given String.
   * 
   * @param w A String
   */
  public Entry(String s) {
    this.str = s;
  }

  /**
   * Returns an ENUM value from the Type class for the Type of entry.
   * 
   * @return enum type of entry
   */
  public Type getType() {
    return type;
  }

  /**
   * Return the entry as a String Object If the entry isn't a String then throws an
   * IllegalArgumentException.
   * 
   * @return String str
   * @throws IllegalArgumentException
   */
  public String getString() {
    if (!(str instanceof String)) {
      throw new IllegalArgumentException("There isnt a String object");
    }
    return str;
  }

  /**
   * Returns the the Entry symbol if it is the correct type. Throws IllegalArgumentException if
   * Entry not a Symbol.
   * 
   * @return enum Symbol
   * @throws IllegalArgumentException
   */
  public Symbol getSymbol() {
    if (!(this.other instanceof Symbol)) {
      throw new IllegalArgumentException("There isnt a Symbol object");
    }
    return this.other;
  }

  /**
   * Get the Value contents of the entry and return as a float. If Entry contents is not a float
   * then throws IllegalArgumentException.
   * 
   * @return the value
   */
  public float getValue() {
    if (!(this.number instanceof Float)) {
      throw new IllegalArgumentException("There isnt a float");
    }
    return this.number;
  }

  /**
   * Turns the Symbol and Type enum objects of the Entry into String format.
   * 
   * @return String of Symbol or Type from Entry.
   */
  // This method was used to allow the Symbol and Type enums to be printable as per clients
  // specification.
  public String toString() {
    if (this.other == null) {
      return this.type.toString();
    }
    if (this.type == null) {
      return this.other.toString();
    }
    return this.other.toString() + this.type.toString();
  }

}

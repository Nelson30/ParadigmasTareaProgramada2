/*
 * @(#)Token.java                        2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package Triangle.SyntacticAnalyzer;

final class Token extends Object {

  protected int kind;
  protected String spelling;
  protected SourcePosition position;

  public Token(int kind, String spelling, SourcePosition position) {

    if (kind == Token.IDENTIFIER) {
      int currentKind = firstReservedWord;
      boolean searching = true;

      while (searching) {
        int comparison = tokenTable[currentKind].compareTo(spelling);
        if (comparison == 0) {
          this.kind = currentKind;
          searching = false;
        } else if (comparison > 0 || currentKind == lastReservedWord) {
          this.kind = Token.IDENTIFIER;
          searching = false;
        } else {
          currentKind++;
        }
      }
    } else this.kind = kind;

    this.spelling = spelling;
    this.position = position;
  }

  public static String spell(int kind) {
    return tokenTable[kind];
  }

  public String toString() {
    return "Kind=" + kind + ", spelling=" + spelling + ", position=" + position;
  }

  // Token classes...

  public static final int

      // literals, identifiers, operators...
      INTLITERAL = 0,
      CHARLITERAL = 1,
      IDENTIFIER = 2,
      OPERATOR = 3,

      // reserved words - must be in alphabetical order...
      ADD = 4,
      ARRAY = 5,
      BEGIN = 6,
      CONST = 7,
      DO = 8,
      ELSE = 9,
      END = 10,
      FUNC = 11,
      IF = 12,
      IN = 13,
      LET = 14,
      OF = 15,
      PROC = 16,
      RECORD = 17,
      REPEAT = 18,
      RUN = 19,
      SUBS = 20,
      THEN = 21,
      TIMES = 22,
      TYPE = 23,
      UNTIL = 24,
      VAR = 25,
      WHILE = 26,
      ZZ = 27,

      // punctuation...
      DOT = 28,
      COLON = 29,
      SEMICOLON = 30,
      COMMA = 31,
      BECOMES = 32,
      IS = 33,

      // brackets...
      LPAREN = 34,
      RPAREN = 35,
      LBRACKET = 36,
      RBRACKET = 37,
      LCURLY = 38,
      RCURLY = 39,

      // special tokens...
      EOT = 40,
      ERROR = 41;

  private static String[] tokenTable =
      new String[] {
        "<int>",
        "<char>",
        "<identifier>",
        "<operator>",
        "add",
        "array",
        "begin",
        "const",
        "do",
        "else",
        "end",
        "func",
        "if",
        "in",
        "let",
        "of",
        "proc",
        "record",
        "repeat",
        "run",
        "subs",
        "then",
        "times",
        "type",
        "until",
        "var",
        "while",
        "zz",
        ".",
        ":",
        ";",
        ",",
        ":=",
        "~",
        "(",
        ")",
        "[",
        "]",
        "{",
        "}",
        "",
        "<error>"
      };

  private static final int firstReservedWord = Token.ARRAY, lastReservedWord = Token.ZZ;
}

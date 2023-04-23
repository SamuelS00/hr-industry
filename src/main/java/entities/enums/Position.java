package entities.enums;

public enum Position {
  
  OPERADOR("Operador"),
  COORDENADOR("Coordenador"),
  DIRETOR("Diretor"),
  RECEPCIONISTA("Recepcionista"),
  CONTADOR("Contador"),
  GERENTE("Gerente"),
  ELETRICISTA("Eletricista");

  private String positionName;

  Position(String positionName) {
    this.positionName = positionName;
  }

  public String getPositionName() {
    return positionName;
  }

  public static Position fromString(String positionName) {
    for (Position position : Position.values()) {
      if (position.getPositionName().equalsIgnoreCase(positionName)) {
        return position;
      }
    }
    throw new IllegalArgumentException("Invalid position name: " + positionName);
  }
}

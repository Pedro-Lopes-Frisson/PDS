1. A classe Calender possui 2 construtores:
    - protected Calendar() -> Constroi um Calendar com a default time zone da instancia da JVM que está a correr o Programa

    - protected Calendar(TimeZone zone, Locale aLocale) -> Constroi um Calendar com uma timezone e locale especifico

2. Ambos os construtores sao PROTECTED para que nao possam ser acedidos. Para instanciar a classe temos no lugar dos construtores 4 metodos:
   -  public static Calendar getInstance() Cria uma instancia de Calendar Usando os valors default Timezone e Locale da jvm sendo que depois a retorna

   -  public static Calendar getInstance(TimeZone zone)   Cria uma instancia de Calendar Usando os valore default de Locale da jvm e um Valor fornecido para a TimeZone sendo que depois retorna esse objeto

   - public static Calendar getInstance(Locale aLocale)   Cria uma instancia de Calendar Usando os valore default de TimeZone da jvm e um Valor fornecido para a Locale sendo que depois retorna esse objeto

   - public static Calendar getInstance(TimeZone zone, Locale aLocale)    Cria uma instancia de Calendar com valores para TimeZone E Locale especificados pelo o utilizador

### É importante referir que o objeto não é instaciado dentro do corpo destes métodos mas sim nos métodos abaixo apresentados
3. Os metodos acima descritos usam este metodo para concluir a instanciação de um objeto
  - private static Calendar createCalendar(TimeZone zone,Locale aLocale)

  - Esta funçao vai efetivamente criar o objeto Calendar e retorna-lo, funcionando então como uma Factory, podendo criar varios tipos de Calendar (Gregorian,Japanese,etc)
  - Oferecendo também uma camada de abstração que permita a fácil criação de um Calendar sem termos de nos preocupar com a forma ccomo esta `Class` foi constuída

#Conclusão
  Conclui-se entao que a classe Calendar implementa o Factory Creational Design Pattern

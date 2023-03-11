Technologie:
- Java 18
- maven
- bibliotek zewnętrzna: commons-io


Instrukcja:
W celu uruchomienia programu należy uruchomić metodę main() w klasie FileSorterApp.
Można również uruchomić aplikację poprzez archiwum .jar wpisując poniższe komendy w terminalu, w folderze z aplikacją:
- mvn clean install
- java -cp target\filesorter-1.0-SNAPSHOT.jar pl.pretius.FileSorterApp


Opis:
- uruchomiona aplikacja na bieżąco sprawdza zawartość folderu o ścieżce opisanej w enumie PathEnum.HOME
- jeżeli w folderze są pliki .xml lub .jar to zostaną one przeniesione do odpowiednich folderów
- powyższe dotyczy również plików dostarczony do głównej lokalizacji w trakcie działania aplikacji
- w głównej lokalizacji istnieje (lub zostanie stworzony) plik count.txt, który zawiera informacje ile plików zostało przeniesionych w trakcie działania aplikacji. Licznik się odnawia po zrestartowaniu aplikacji.
- pliki o tych samych nazwach zostaną nadpisane
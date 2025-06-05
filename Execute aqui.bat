@echo off
REM Cria a pasta bin, se não existir
if not exist bin (
    mkdir bin
)

echo Compilando os arquivos Java...
javac -d bin src\aplicacao\Aplicacao.java src\servico\Servico.java src\modelo\*.java src\repositorio\*.java

if %errorlevel% neq 0 (
    echo Houve erro na compilação.
    pause
    exit /b
)

echo.
echo Executando a aplicacao...
java -cp bin aplicacao.Aplicacao

echo.
pause

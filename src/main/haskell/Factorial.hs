import System.Environment (getArgs)

factorial :: Integer  -> Integer  
factorial n 
        | n == 0 = 1
        | n > 0  = n * factorial (n - 1)
        | n < 0  = error "Valor negativo"


main = do
    (numero:args) <- getArgs
    let resultado = factorial (read numero :: Integer) 
    print resultado

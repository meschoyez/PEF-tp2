import System.Environment (getArgs)

fibonacci :: Integer -> Integer 
fibonacci n 
         | n == 0 = 1
         | n == 1 = 1
         | n > 1  = fibonacci (n - 2) + fibonacci (n - 1)
         | n < 0  = error "Valor negativo"

main :: IO ()
main = do
    (numero:args) <- getArgs
    let resultado = fibonacci (read numero :: Integer) 
    print resultado

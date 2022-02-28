import java.util.Scanner;

public class Exercicio2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("------------------------------------------------------------");
        System.out.println("Digite uma senha que atenda aos seguintes critérios:"+ "\n" +
                "* Possui no mínimo 6 caracteres."+ "\n" +
                "* Contém pelo menos 1 dígito."+ "\n" +
                "* Contém pelo menos 1 letra minúscula." + "\n" +
                "* Contém pelo menos 1 letra maiúscula." + "\n" +
                "* Contém pelo menos 1 caractere especial dentre esses !@#$%^&*()-+"
        );
        System.out.println("------------------------------------------------------------");
        System.out.print("Digite a senha para cadastro: ");
        String senha = sc.nextLine();

        validarSenha(senha);
        System.out.println("Senha cadastrada com sucesso!");

        sc.close();
    }

    public static void validarSenha(String senha){

        int caracterValida = 0;

        if(senha.length() < 6){
            caracterValida = 6 - senha.length();
        }else{

            if (!senha.matches("(.*)[0-9](.*)")){
                caracterValida++;
            }
            if (!senha.matches("(.*)[a-z](.*)")){
                caracterValida++;
            }
            if (!senha.matches("(.*)[A-Z](.*)")){
                caracterValida++;
            }
            if (!senha.matches("(.*)[!@#$%^&*()-+](.*)")){
                caracterValida++;
            }
        }

        System.out.printf("\n Caracteres restantes para sua senha atender aos requisitos de segurança:  %s",caracterValida);

        System.out.println(" ");

        if (caracterValida > 0){

        }
    }
}

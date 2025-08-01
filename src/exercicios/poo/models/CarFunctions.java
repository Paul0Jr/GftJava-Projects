package exercicios.poo.models;

import java.util.Scanner;

public class CarFunctions {
    Scanner scan = new Scanner(System.in);
    private boolean OnOff = false;
    private String direction = "reto";
    private int gear;
    private int speed;

    private int option = 0;
    private final int incspeed = 10;

    public boolean isOnOff() {
        return OnOff;
    }

    public void setOnOff(boolean onOff) {
        OnOff = onOff;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void TurnOn() {
        if (getGear() == 0 && getSpeed() == 0 && !(isOnOff())) {
            setOnOff(true);
            System.out.println("\nCarro ligado!");
        } else {
            if (isOnOff()) {
                System.out.println("\nO carro já está ligado!");
            } else {
                System.out.println("\nO carro precisa estar parado e com a marcha no neutro!");
            }
        }
    }

    public void TurnOff() {
        if (getGear() == 0 && getSpeed() == 0 && isOnOff()) {
            setOnOff(false);
            System.out.println("\nCarro desligado!");
        } else {
            if (!isOnOff()) {
                System.out.println("\nO carro já está desligado!");
            } else {
                System.out.println("\nO carro precisa estar parado e com a marcha no neutro!");
            }
        }
    }

    public void SpeedUp() {
        int LIMIT;
        if (isOnOff()) {
            switch (getGear()) {
                case 1:
                    LIMIT = 20;
                    if (getSpeed() >= 0 && getSpeed() <= LIMIT) {
                        if (getSpeed() == 0) {
                            setSpeed(getSpeed() + incspeed + 1);

                        } else {
                            setSpeed(getSpeed() + incspeed);
                        }
                    } else {
                        System.out.println("\nTroque a marcha para aumentar a velocidade!");
                    }
                    break;

                case 2:
                    LIMIT = 40;
                    if (getSpeed() >= 21 && getSpeed() <= LIMIT) {
                        setSpeed(getSpeed() + incspeed);
                    } else {
                        System.out.println("\nTroque a marcha para aumentar a velocidade!");
                    }
                    break;

                case 3:
                    LIMIT = 60;
                    if (getSpeed() >= 41 && getSpeed() <= LIMIT) {
                        setSpeed(getSpeed() + incspeed);
                    } else {
                        System.out.println("\nTroque a marcha para aumentar a velocidade!");
                    }
                    break;

                case 4:
                    LIMIT = 80;
                    if (getSpeed() >= 61 && getSpeed() <= LIMIT) {
                        setSpeed(getSpeed() + incspeed);
                    } else {
                        System.out.println("\nTroque a marcha para aumentar a velocidade!");
                    }
                    break;
                case 5:
                    LIMIT = 100;
                    if (getSpeed() >= 81 && getSpeed() <= LIMIT) {
                        setSpeed(getSpeed() + incspeed);
                    } else {
                        System.out.println("\nTroque a marcha para aumentar a velocidade!");
                    }
                    break;
                case 6:
                    LIMIT = 120;
                    if (getSpeed() >= 101 && getSpeed() <= LIMIT) {
                        setSpeed(getSpeed() + incspeed);
                    } else {
                        if (getSpeed() >= LIMIT)
                            System.out.println("\nLimite de velocidade atingido!");
                    }
                    System.out.println("\nLimite de velocidade atingido!");
                    break;
                default:
                    System.out.println("Saia do neutro!");
            }
        } else {
            System.out.println("\nO carro precisa estar ligado e com a marcha acima do neutro!");
        }
    }

    public void SpeedDown() {
        int LIMIT;
        if (isOnOff()) {
            switch (getGear()) {
                case 6:
                    LIMIT = 101;
                    if (getSpeed() <= 120 && getSpeed() >= LIMIT) {
                        setSpeed(getSpeed() - incspeed);
                    } else {
                        System.out.println("\nTroque de marcha para reduzir a velocidade!");
                    }
                    break;
                case 5:
                    LIMIT = 81;
                    if (getSpeed() <= 100 && getSpeed() >= LIMIT) {
                        setSpeed(getSpeed() - incspeed);
                    } else {
                        System.out.println("\nTroque de marcha para reduzir a velocidade!");
                    }
                case 4:
                    LIMIT = 61;
                    if (getSpeed() <= 80 && getSpeed() >= LIMIT) {
                        setSpeed(getSpeed() - incspeed);
                    } else {
                        System.out.println("\nTroque de marcha para reduzir a velocidade!");
                    }
                case 3:
                    LIMIT = 41;
                    if (getSpeed() <= 60 && getSpeed() >= LIMIT) {
                        setSpeed(getSpeed() - incspeed);
                    } else {
                        System.out.println("\nTroque de marcha para reduzir a velocidade!");
                    }
                case 2:
                    LIMIT = 21;
                    if (getSpeed() <= 40 && getSpeed() >= LIMIT) {
                        setSpeed(getSpeed() - incspeed);
                    } else {
                        System.out.println("\nTroque de marcha para reduzir a velocidade!");
                    }
                case 1:
                    LIMIT = 0;
                    if (getSpeed() <= 20 && getSpeed() >= LIMIT) {
                        setSpeed(getSpeed() - incspeed);
                    } else {
                        System.out.println("\nTroque de marcha para reduzir a velocidade!");
                    }
                default:
                    System.out.println("Você já está no neutro!");
                    break;
            }
        } else {
            System.out.println("\nO carro precisa estar ligado e com a marcha no neutro!");
        }
    }

    public void ChangeGear() {
        int LIMIT;
        if (isOnOff()) {
            System.out.print("\nSubir marcha[1]" +
                    "\nDescer marcha[2]\n");
            System.out.print("Digite sua opção: ");
            option = scan.nextInt();
            switch (option) {
                case 1:
                    switch (getGear()) {
                        case 0:
                            LIMIT = 20;
                            if (getSpeed() > 0 || getSpeed() <= LIMIT) {
                                setGear(getGear() + 1);
                            } else {
                                System.out.println("\nAumente a velocidade para trocar a marcha!");
                            }
                            break;

                        case 1:
                            LIMIT = 40;
                            if (getSpeed() >= 21 && getSpeed() <= LIMIT) {
                                setGear(getGear() + 1);
                            } else {
                                System.out.println("\nAumente a velocidade para trocar a marcha!");
                            }
                            break;

                        case 2:
                            LIMIT = 60;
                            if (getSpeed() >= 41 && getSpeed() <= LIMIT) {
                                setGear(getGear() + 1);
                            } else {
                                System.out.println("\nAumente a velocidade para trocar a marcha!");
                            }
                            break;

                        case 3:
                            LIMIT = 80;
                            if (getSpeed() >= 61 && getSpeed() <= LIMIT) {
                                setGear(getGear() + 1);
                            } else {
                                System.out.println("\nAumente a velocidade para trocar a marcha!");
                            }
                            break;

                        case 4:
                            LIMIT = 100;
                            if (getSpeed() >= 81 && getSpeed() <= LIMIT) {
                                setGear(getGear() + 1);
                            } else {
                                System.out.println("\nAumente a velocidade para trocar a marcha!");
                            }
                            break;

                        case 5:
                            LIMIT = 120;
                            if (getSpeed() >= 101 && getSpeed() <= LIMIT) {
                                setGear(getGear() + 1);
                            } else {
                                System.out.println("\nAumente a velocidade para trocar a marcha!");
                            }
                            break;
                        case 6:
                            System.out.println("\nLimite do câmbio atingido!");
                            break;
                        default:
                            System.out.println("\nOpção inválida!");
                    }
                    break;
                case 2:
                    //DECREMENTO DE MARCHA
                    switch (getGear()) {
                        case 6:
                            LIMIT = 101;
                            if (getSpeed() <= 120 && getSpeed() >= LIMIT) {
                                setGear(getGear() - 1);
                            } else {
                                System.out.println("\nReduza a velocidade para trocar a marcha!");
                            }
                            break;

                        case 5:
                            LIMIT = 81;
                            if (getSpeed() <= 101 && getSpeed() >= LIMIT) {
                                setGear(getGear() - 1);
                            } else {
                                System.out.println("\nReduza a velocidade para trocar a marcha!");
                            }
                            break;

                        case 4:
                            LIMIT = 61;
                            if (getSpeed() <= 81 && getSpeed() >= LIMIT) {
                                setGear(getGear() - 1);
                            } else {
                                System.out.println("\nReduza a velocidade para trocar a marcha!");
                            }
                            break;

                        case 3:
                            LIMIT = 41;
                            if (getSpeed() <= 61 && getSpeed() >= LIMIT) {
                                setGear(getGear() - 1);
                            } else {
                                System.out.println("\nReduza a velocidade para trocar a marcha!");
                            }
                            break;
                        case 2:
                            LIMIT = 21;
                            if (getSpeed() <= 41 && getSpeed() >= LIMIT) {
                                setGear(getGear() - 1);
                            } else {
                                System.out.println("\nReduza a velocidade para trocar a marcha!");
                            }
                            break;
                        case 1:
                            setGear(0);
                            setSpeed(0);
                        default:
                            System.out.println("\nOpção inválida!");
                    }
                    break;
                default:
                    System.out.println("\nOpção inválida!");
            }

        } else {
            System.out.println("\nO carro precisa estar ligado!");

        }
    }

    public void Status() {
        System.out.printf("\nMotor: %b" +
                "\nVelocidade: %d" +
                "\nMarcha: %d" +
                "\nDireção: %s", isOnOff(), getSpeed(), getGear(), getDirection());
    }

    public void TurnLR() {
        if (!(isOnOff())) {
            System.out.println("\nO motor precisa estar ligado!");
            return;
        }
        if (getSpeed() >= 1) {
            if (getSpeed() < 40) {
                System.out.print("\nEsquerda[1]" +
                        "\nDireita[2]\n");
                System.out.print("Digite sua opção: ");
                option = scan.nextInt();
                switch (option) {
                    case 1:
                        if (getDirection().equals("Direita")) {
                            setDirection("Reto");
                            break;
                        } else {
                            setDirection("Esquerda");
                            break;
                        }
                    case 2:
                        if (getDirection().equals("Esquerda")) {
                            setDirection("Reto");
                            break;
                        } else {
                            setDirection("Direita");
                            break;
                        }
                    default:
                        System.out.println("\nOpção inválida!");
                }
            } else {
                System.out.println("\nReduza a velocidade para pelo menos 40km/h!");
            }
        } else {
            System.out.println("\nAumente a velocidade para pelo menos 1km/h!");
        }
    }
}


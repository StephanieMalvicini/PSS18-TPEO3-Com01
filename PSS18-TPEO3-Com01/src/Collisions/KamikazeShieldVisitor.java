package Collisions;

public class KamikazeShieldVisitor extends PlayerVisitor {
    @Override
    public void visitEnemy(EnemyCollider e) {
        e.getO().damage(10000);//deberiamos llamar a destruir?

    }


}

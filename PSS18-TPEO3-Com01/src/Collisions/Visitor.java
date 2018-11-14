package Collisions;


public abstract class Visitor {

    public void visitEnemy(EnemyCollider e) {

    }

    public void visitPlayerBullet(PlayerBulletCollider b) {

    }

    public void visitEnemyBullet(EnemyBulletCollider b) {

    }

    public void visitPlayer(PlayerCollider p) {

    }

    public void visitEnemyBarricade(EnemyBarricadeCollider b) {

    }

    public void visitPowerUp(PowerUpCollider b) {

    }

    public void visitKamikazeShield(KamikazeShieldCollider b) {

    }

    public void visitPiercingBullet(PiercingBulletCollider b) {

    }


    public void visitCommonBarricade(CommonBarricadeCollider commonBarricadeCollider){

    }
}

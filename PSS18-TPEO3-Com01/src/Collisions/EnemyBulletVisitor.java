package Collisions;

public class EnemyBulletVisitor extends Visitor {
    protected float d;

    public EnemyBulletVisitor(float dmg){
        d = dmg;
    }





    @Override
    public void visitPlayer(PlayerCollider p) {
        p.getO().damage(d);

    }

    @Override
    public void visitEnemyBarricade(EnemyBarricadeCollider b) {
    }


    @Override
    public void visitPowerUp(PowerUpCollider b) {

    }

    @Override
    public void visitCommonBarricade(CommonBarricadeCollider b) {
        b.getO().damage(d);
    }

    @Override
    public void visitKamikazeShield(KamikazeShieldCollider b) {
        b.getO().damage(d);
    }


}

.source                  HOME.java
.class                   public HOME
.super                   java/lang/Object
.field public kitchenSwitch LHOME/classes/standard/Input;
.field public kitchenLamps Ljava/util/ArrayList;
.method public <init>()V
    .limit stack 4
    .limit locals 3
    aload_0
    invokespecial java/lang/Object/<init>()V
.line 1
    aload_0
    new HOME/classes/standard/Input
    dup
    bipush 1
    invokespecial HOME/classes/standard/Input.<init>(I)V
    aload_0
    swap
    putfield HOME/kitchenSwitch LHOME/classes/standard/Input;
.line 2
    aload_0
    aload_0
    invokevirtual HOME/getKitchenLamps()Ljava/util/ArrayList;
    astore 2
    aload 2
    aload_0
    swap
    putfield HOME/kitchenLamps Ljava/util/ArrayList;
return
.end method

.method public Setup()V
    .limit stack 0
    .limit locals 1
    return
.end method

.method public getKitchenLamps()Ljava/util/ArrayList;
    .limit stack 4
    .limit locals 3
.line 11
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 1
.line 13
    bipush 2
    istore 2
.line 14
    Label1:
    iload 2
    bipush 4
    if_icmpgt Label2
.line 15
    aload 1
    new HOME/classes/standard/Output
    dup
    iload 2
    invokespecial HOME/classes/standard/Output.<init>(I)V
    invokevirtual java/util/ArrayList.add(LHOME/classes/standard/Output;)Z
.line 16
    iload 2
    iconst_1
    iadd
    istore 2
    goto Label1
    Label2:
.line 19
    aload 1
    areturn
.end method


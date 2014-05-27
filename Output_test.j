.source                  HOME.java
.class                   public HOME
.super                   java/lang/Object
.field public TESTER LHOME/classes/standard/Input;
.field public TESTER2 LHOME/classes/standard/Input;
.field public abe1 Ljava/util/ArrayList;
.field public abe2 Ljava/util/HashMap;
.field public f Ljava/lang/Boolean;
.field public listBool Ljava/util/ArrayList;
.field public t Ljava/lang/String;
.field public y Ljava/lang/Double;
.field public z Ljava/lang/Integer;
.method public <init>()V
    .limit stack 11
    .limit locals 11
    aload_0
    invokespecial java/lang/Object/<init>()V
.line 1
    aload_0
    new HOME/classes/standard/Input
    dup
    bipush 32
    invokespecial HOME/classes/standard/Input.<init>(I)V
    aload_0
    swap
    putfield HOME/TESTER LHOME/classes/standard/Input;
.line 2
    aload_0
    aconst_null
    aload_0
    swap
    putfield HOME/TESTER2 LHOME/classes/standard/Input;
.line 3
    aload_0
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 3
    aload 3
    aload_0
    swap
    putfield HOME/abe1 Ljava/util/ArrayList;
.line 4
    aload_0
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 4
    aload 4
    aload_0
    swap
    putfield HOME/abe2 Ljava/util/HashMap;
.line 5
    aload_0
    iconst_0
    invokestatic java/lang/Boolean.valueOf(Z)Ljava/lang/Boolean;
    aload_0
    swap
    putfield HOME/f Ljava/lang/Boolean;
.line 6
    aload_0
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 6
    aload 6
    aload_0
    getfield HOME/f Ljava/lang/Boolean;
    invokevirtual java/lang/Boolean.booleanValue()Z
    invokestatic java/lang/Boolean.valueOf(Z)Ljava/lang/Boolean;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 6
    iconst_0
    invokestatic java/lang/Boolean.valueOf(Z)Ljava/lang/Boolean;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 6
    iconst_1
    invokestatic java/lang/Boolean.valueOf(Z)Ljava/lang/Boolean;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 6
    iconst_1
    invokestatic java/lang/Boolean.valueOf(Z)Ljava/lang/Boolean;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 6
    aload_0
    swap
    putfield HOME/listBool Ljava/util/ArrayList;
.line 7
    aload_0
    ldc ""
    aload_0
    swap
    putfield HOME/t Ljava/lang/String;
.line 9
    aload_0
    dconst_0
    invokestatic java/lang/Double.valueOf(D)Ljava/lang/Double;
    aload_0
    swap
    putfield HOME/y Ljava/lang/Double;
.line 10
    aload_0
    iconst_0
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    aload_0
    swap
    putfield HOME/z Ljava/lang/Integer;
return
.end method

.method public Setup()V
    .limit stack 9
    .limit locals 54
.line 13
    aload_0
    invokevirtual HOME/returnTest2()LHOME/classes/standard/Input;
    aload_0
    swap
    putfield HOME/TESTER2 LHOME/classes/standard/Input;
.line 14
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 1
    aload 1
    aload_0
    swap
    putfield HOME/abe1 Ljava/util/ArrayList;
.line 15
    aload_0
    getfield HOME/abe1 Ljava/util/ArrayList;
    aload_0
    swap
    putfield HOME/abe1 Ljava/util/ArrayList;
.line 16
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 2
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 3
    aload 3
    aload_0
    getfield HOME/TESTER LHOME/classes/standard/Input;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 3
    aload_0
    getfield HOME/TESTER2 LHOME/classes/standard/Input;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 2
    aload 3
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 4
    aload 4
    aload_0
    getfield HOME/TESTER LHOME/classes/standard/Input;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 4
    aload_0
    getfield HOME/TESTER2 LHOME/classes/standard/Input;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 2
    aload 4
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 2
    aload_0
    swap
    putfield HOME/abe1 Ljava/util/ArrayList;
.line 17
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 5
    aload 5
    ldc "dic1"
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 6
    aload 6
    ldc "dic1"
    aload_0
    getfield HOME/TESTER LHOME/classes/standard/Input;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 6
    ldc "dic2"
    aload_0
    getfield HOME/TESTER2 LHOME/classes/standard/Input;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 6
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 5
    ldc "dic1"
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 7
    aload 7
    ldc "dic1"
    aload_0
    getfield HOME/TESTER LHOME/classes/standard/Input;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 7
    ldc "dic2"
    aload_0
    getfield HOME/TESTER2 LHOME/classes/standard/Input;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 7
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 5
    aload_0
    swap
    putfield HOME/abe2 Ljava/util/HashMap;
.line 19
    ldc "hej"
    ldc " "
    astore 9
    astore 8
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder.<init>()V
    aload 8
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    aload 9
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder.toString()Ljava/lang/String;
    ldc "med"
    astore 11
    astore 10
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder.<init>()V
    aload 10
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    aload 11
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder.toString()Ljava/lang/String;
    ldc " "
    astore 13
    astore 12
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder.<init>()V
    aload 12
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    aload 13
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder.toString()Ljava/lang/String;
    ldc "dig"
    astore 15
    astore 14
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder.<init>()V
    aload 14
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    aload 15
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder.toString()Ljava/lang/String;
    aload_0
    swap
    putfield HOME/t Ljava/lang/String;
.line 20
    ldc2_w 24.3d
    dneg
    invokestatic java/lang/Double.valueOf(D)Ljava/lang/Double;
    aload_0
    swap
    putfield HOME/y Ljava/lang/Double;
.line 21
    bipush 3
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    aload_0
    swap
    putfield HOME/z Ljava/lang/Integer;
.line 23
    aload_0
    getfield HOME/y Ljava/lang/Double;
    invokevirtual java/lang/Double.doubleValue()D
    dstore 16
.line 24
    aload_0
    getfield HOME/y Ljava/lang/Double;
    invokevirtual java/lang/Double.doubleValue()D
    dconst_1
    dadd
    invokestatic java/lang/Double.valueOf(D)Ljava/lang/Double;
    aload_0
    swap
    putfield HOME/y Ljava/lang/Double;
.line 25
    aload_0
    getfield HOME/z Ljava/lang/Integer;
    invokevirtual java/lang/Integer.intValue()I
    iconst_1
    iadd
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    aload_0
    swap
    putfield HOME/z Ljava/lang/Integer;
.line 26
    aload_0
    aload_0
    getfield HOME/y Ljava/lang/Double;
    invokevirtual java/lang/Double.doubleValue()D
    invokevirtual HOME/PrintD(D)D
    pop2
.line 27
    aload_0
    aload_0
    getfield HOME/z Ljava/lang/Integer;
    invokevirtual java/lang/Integer.intValue()I
    invokevirtual HOME/PrintI(I)I
    pop
.line 28
    dload 16
    dconst_1
    dsub
    dstore 16
.line 29
    aload_0
    getfield HOME/z Ljava/lang/Integer;
    invokevirtual java/lang/Integer.intValue()I
    iconst_1
    isub
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    aload_0
    swap
    putfield HOME/z Ljava/lang/Integer;
.line 30
    aload_0
    dload 16
    invokevirtual HOME/PrintD(D)D
    pop2
.line 31
    aload_0
    aload_0
    getfield HOME/z Ljava/lang/Integer;
    invokevirtual java/lang/Integer.intValue()I
    invokevirtual HOME/PrintI(I)I
    pop
.line 33
    bipush 3
    istore 18
.line 35
    aload_0
    getfield HOME/t Ljava/lang/String;
    ldc " "
    astore 20
    astore 19
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder.<init>()V
    aload 19
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    aload 20
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder.toString()Ljava/lang/String;
    ldc "Master"
    astore 22
    astore 21
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder.<init>()V
    aload 21
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    aload 22
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder.toString()Ljava/lang/String;
    aload_0
    swap
    putfield HOME/t Ljava/lang/String;
.line 36
    aload_0
    aload_0
    getfield HOME/t Ljava/lang/String;
    invokevirtual HOME/PrintS(Ljava/lang/String;)Ljava/lang/String;
    pop
.line 42
    aload_0
    getfield HOME/abe1 Ljava/util/ArrayList;
    bipush 1
    invokevirtual java/util/ArrayList.get(I)Ljava/lang/Object;
    checkcast java/util/ArrayList
    bipush 0
    invokevirtual java/util/ArrayList.get(I)Ljava/lang/Object;
    checkcast HOME/classes/standard/Input
    astore 23
.line 43
    aload_0
    aload 23
    invokevirtual HOME/classes/standard/Input.getPort()I
    invokevirtual HOME/PrintI(I)I
    pop
.line 45
    aload_0
    getfield HOME/abe2 Ljava/util/HashMap;
    ldc "dic1"
    invokevirtual java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast java/util/HashMap
    ldc "dic2"
    invokevirtual java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast HOME/classes/standard/Input
    astore 23
.line 46
    aload_0
    aload 23
    invokevirtual HOME/classes/standard/Input.getPort()I
    invokevirtual HOME/PrintI(I)I
    pop
.line 51
    iload 18
    bipush 3
    isub
    istore 18
.line 52
    iload 18
    bipush 3
    imul
    istore 18
.line 53
    iload 18
    bipush 3
    idiv
    istore 18
.line 54
    iload 18
    bipush 20
    irem
    istore 18
.line 60
    iload 18
    sipush 314
    if_icmpeq Label1
.line 62
    bipush 43
    iload 18
    if_icmpeq Label2
.line 65
    iload 18
    bipush 4
    iadd
    istore 18
.line 66
    aload_0
    getfield HOME/y Ljava/lang/Double;
    invokevirtual java/lang/Double.doubleValue()D
    ldc2_w 4.d
    dadd
    invokestatic java/lang/Double.valueOf(D)Ljava/lang/Double;
    aload_0
    swap
    putfield HOME/y Ljava/lang/Double;
    goto Label3
    Label1:
.line 61
    iload 18
    iconst_1
    iadd
    istore 18
    goto Label3
    Label2:
.line 63
    iload 18
    bipush 123
    iadd
    istore 18
    goto Label3
    Label3:
.line 69
    iconst_1
    istore 24
.line 70
    iload 24
    ifne Label4
.line 72
    iload 24
    ifne Label5
.line 75
    aload_0
    ldc "if(XXX) - Intet virker"
    invokevirtual HOME/PrintS(Ljava/lang/String;)Ljava/lang/String;
    pop
    goto Label6
    Label4:
.line 71
    aload_0
    ldc "if(XXX) - Virker"
    invokevirtual HOME/PrintS(Ljava/lang/String;)Ljava/lang/String;
    pop
    goto Label6
    Label5:
.line 73
    aload_0
    ldc "if(XXX) - Noget Virker"
    invokevirtual HOME/PrintS(Ljava/lang/String;)Ljava/lang/String;
    pop
    goto Label6
    Label6:
.line 78
    iload 18
    i2d
    ldc2_w 3.0d
    dcmpl
    ifeq Label7
    goto Label8
    Label7:
.line 79
    aload_0
    getfield HOME/y Ljava/lang/Double;
    invokevirtual java/lang/Double.doubleValue()D
    ldc2_w 3.d
    dcmpl
    iflt Label9
.line 82
    iload 18
    iconst_1
    isub
    istore 18
    goto Label10
    Label9:
.line 80
    aload_0
    getfield HOME/y Ljava/lang/Double;
    invokevirtual java/lang/Double.doubleValue()D
    dconst_1
    dadd
    invokestatic java/lang/Double.valueOf(D)Ljava/lang/Double;
    aload_0
    swap
    putfield HOME/y Ljava/lang/Double;
    goto Label10
    Label10:
    goto Label8
    Label8:
.line 86
    aload_0
    iload 18
    invokevirtual HOME/PrintI(I)I
    pop
.line 92
    goto Label12
    Label11:
.line 93
    iload 18
    iconst_1
    iadd
    istore 18
    Label12:
    iload 18
    sipush 300
    if_icmplt Label11
.line 96
    Label13:
    iconst_1
    aload_0
    getfield HOME/y Ljava/lang/Double;
    invokevirtual java/lang/Double.doubleValue()D
    ldc2_w 8.1d
    dcmpl
    ifle Label15
    iconst_1
    goto Label16
    Label15:
    iconst_0
    Label16:
    if_icmpeq Label14
.line 97
    aload_0
    getfield HOME/y Ljava/lang/Double;
    invokevirtual java/lang/Double.doubleValue()D
    dconst_1
    dadd
    invokestatic java/lang/Double.valueOf(D)Ljava/lang/Double;
    aload_0
    swap
    putfield HOME/y Ljava/lang/Double;
    goto Label13
    Label14:
.line 100
    goto Label18
    Label17:
.line 101
    goto Label20
    Label19:
.line 102
    aload_0
    getfield HOME/y Ljava/lang/Double;
    invokevirtual java/lang/Double.doubleValue()D
    dconst_1
    dadd
    invokestatic java/lang/Double.valueOf(D)Ljava/lang/Double;
    aload_0
    swap
    putfield HOME/y Ljava/lang/Double;
    Label20:
    iload 18
    bipush 3
    if_icmpgt Label19
    Label18:
    aload_0
    getfield HOME/y Ljava/lang/Double;
    invokevirtual java/lang/Double.doubleValue()D
    ldc2_w 3.2d
    dcmpl
    iflt Label17
.line 112
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 25
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 26
    aload 26
    bipush 11
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 26
    bipush 22
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 26
    bipush 33
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 25
    aload 26
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 27
    aload 27
    bipush 44
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 27
    bipush 55
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 27
    bipush 66
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 25
    aload 27
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 28
    aload 28
    bipush 77
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 28
    bipush 88
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 28
    bipush 99
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 25
    aload 28
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
.line 114
    aload 25
    bipush 1
    invokevirtual java/util/ArrayList.get(I)Ljava/lang/Object;
    checkcast java/util/ArrayList
    bipush 1
    sipush 555
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/ArrayList.set(ILjava/lang/Object;)Ljava/lang/Object;
    pop
.line 115
    aload 25
    bipush 1
    invokevirtual java/util/ArrayList.get(I)Ljava/lang/Object;
    checkcast java/util/ArrayList
    dup
    bipush 1
    swap
    bipush 1
    invokevirtual java/util/ArrayList.get(I)Ljava/lang/Object;
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer/intValue()I
    sipush 5000
    iadd
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/ArrayList.set(ILjava/lang/Object;)Ljava/lang/Object;
    pop
.line 117
    aload 25
    invokeinterface java/util/List/iterator()Ljava/util/Iterator; 1
    astore 29
    Label21:
    aload 29
    invokeinterface java/util/Iterator/hasNext()Z 1
    ifeq Label22
    aload 29
    invokeinterface java/util/Iterator/next()Ljava/lang/Object; 1
    checkcast java/util/ArrayList
    astore 30
.line 118
    aload 30
    invokeinterface java/util/List/iterator()Ljava/util/Iterator; 1
    astore 31
    Label23:
    aload 31
    invokeinterface java/util/Iterator/hasNext()Z 1
    ifeq Label24
    aload 31
    invokeinterface java/util/Iterator/next()Ljava/lang/Object; 1
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer.intValue()I
    istore 32
.line 119
    aload_0
    iload 32
    invokevirtual HOME/PrintI(I)I
    pop
    goto Label23
    Label24:
    goto Label21
    Label22:
.line 126
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 33
.line 127
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 34
.line 128
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 35
    aload 35
    astore 34
.line 129
    aload 34
    astore 34
.line 131
    aload_0
    invokevirtual HOME/hejd()Ljava/util/HashMap;
    astore 33
.line 132
    aload 33
    astore 34
.line 134
    aload 34
    ldc "dic1"
    invokevirtual java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast java/util/HashMap
    ldc "two"
    aload 34
    ldc "dic1"
    invokevirtual java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast java/util/HashMap
    ldc "two"
    invokevirtual java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer.intValue()I
    sipush 203
    imul
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
.line 135
    aload 34
    ldc "dic1"
    invokevirtual java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast java/util/HashMap
    dup
    ldc "one"
    swap
    ldc "one"
    invokevirtual java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer/intValue()I
    sipush 202
    isub
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
.line 137
    aload 34
    ldc "dic1"
    invokevirtual java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast java/util/HashMap
    invokevirtual java/util/HashMap/values()Ljava/util/Collection;
    invokeinterface java/util/Collection/iterator()Ljava/util/Iterator; 1
    astore 39
    Label25:
    aload 39
    invokeinterface java/util/Iterator/hasNext()Z 1
    ifeq Label26
    aload 39
    invokeinterface java/util/Iterator/next()Ljava/lang/Object; 1
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer.intValue()I
    istore 40
.line 138
    aload_0
    iload 40
    invokevirtual HOME/PrintI(I)I
    pop
    goto Label25
    Label26:
.line 146
    bipush 3
    bipush 3
    bipush 3
    imul
    imul
    iload 18
    iadd
    istore 41
.line 147
    iconst_1
    iconst_0
    iconst_1
    istore 43
    ifne Label28
    iload 43
    ifne Label28
    iconst_0
    goto Label27
    Label28:
    iconst_1
    Label27:
    istore 44
    ifeq Label29
    iload 44
    ifeq Label29
    iconst_1
    goto Label30
    Label29:
    iconst_0
    Label30:
    istore 44
.line 148
    bipush 3
    bipush 3
    if_icmple Label31
    iconst_1
    goto Label32
    Label31:
    iconst_0
    Label32:
    iconst_1
    istore 46
    ifeq Label33
    iload 46
    ifeq Label33
    iconst_1
    goto Label34
    Label33:
    iconst_0
    Label34:
    istore 46
.line 149
    iconst_1
    iconst_0
    istore 48
    ifne Label36
    iload 48
    ifne Label36
    iconst_0
    goto Label35
    Label36:
    iconst_1
    Label35:
    istore 48
.line 150
    ldc "asdf"
    astore 49
.line 152
    aload_0
    aload 49
    invokevirtual HOME/PrintS(Ljava/lang/String;)Ljava/lang/String;
    pop
.line 158
    aload_0
    aload_0
    getfield HOME/TESTER LHOME/classes/standard/Input;
    invokevirtual HOME/classes/standard/Input.getPort()I
    invokevirtual HOME/PrintI(I)I
    pop
.line 166
    aload_0
    getfield HOME/TESTER2 LHOME/classes/standard/Input;
    astore 50
.line 168
    new HOME/classes/standard/Input
    dup
    bipush 42
    invokespecial HOME/classes/standard/Input.<init>(I)V
    astore 50
.line 169
    aload_0
    aload 50
    invokevirtual HOME/classes/standard/Input.getPort()I
    invokevirtual HOME/PrintI(I)I
    pop
.line 172
    aload_0
    invokevirtual HOME/returnForkTest1()I
    pop
.line 173
    aload_0
    invokevirtual HOME/returnForkTest2()I
    pop
.line 174
    aload_0
    invokevirtual HOME/returnForkTest3()I
    pop
.line 176
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 51
.line 177
    aload_0
    invokevirtual HOME/hejz()Ljava/util/ArrayList;
    astore 51
.line 178
    aload 51
    bipush 0
    invokevirtual java/util/ArrayList.get(I)Ljava/lang/Object;
    checkcast java/util/ArrayList
    astore 53
.line 179
    aload_0
    aload 53
    bipush 0
    invokevirtual java/util/ArrayList.get(I)Ljava/lang/Object;
    checkcast java/lang/String
    invokevirtual HOME/PrintS(Ljava/lang/String;)Ljava/lang/String;
    pop
    return
.end method

.method public returnTest2()LHOME/classes/standard/Input;
    .limit stack 3
    .limit locals 2
.line 183
    new HOME/classes/standard/Input
    dup
    sipush 333
    invokespecial HOME/classes/standard/Input.<init>(I)V
    astore 1
.line 184
    aload 1
    areturn
.end method

.method public returnForkTest1()I
    .limit stack 3
    .limit locals 1
.line 188
    bipush 3
    bipush 3
    if_icmpeq Label37
    goto Label38
    Label37:
.line 189
    bipush 5
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 5
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
    Label38:
.line 191
    bipush 3
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 3
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
.end method

.method public hej()Ljava/lang/String;
    .limit stack 3
    .limit locals 2
.line 195
    ldc "HEJ"
    astore 1
.line 196
    aload 1
    dup
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    areturn
.end method

.method public returnForkTest2()I
    .limit stack 3
    .limit locals 1
.line 200
    bipush 3
    bipush 4
    if_icmpeq Label39
.line 202
    bipush 5
    bipush 6
    if_icmpeq Label40
.line 205
    bipush 8
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 8
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
    Label39:
.line 201
    bipush 6
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 6
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
    Label40:
.line 203
    bipush 7
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 7
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
.end method

.method public returnForkTest3()I
    .limit stack 3
    .limit locals 1
.line 210
    bipush 1
    bipush 2
    if_icmpeq Label42
    goto Label43
    Label42:
.line 211
    bipush 3
    bipush 4
    if_icmpeq Label44
    goto Label45
    Label44:
.line 212
    bipush 5
    bipush 6
    if_icmpeq Label46
    goto Label47
    Label46:
.line 213
    bipush 7
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 7
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
    Label47:
    goto Label45
    Label45:
    goto Label43
    Label43:
.line 217
    bipush 0
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 0
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
.end method

.method public hejz()Ljava/util/ArrayList;
    .limit stack 2
    .limit locals 5
.line 221
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 1
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 2
    aload 1
    aload 2
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
.line 222
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 3
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 4
    aload 4
    ldc "lol2"
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 3
    aload 4
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 3
    astore 1
.line 223
    aload 1
    areturn
.end method

.method public hejd()Ljava/util/HashMap;
    .limit stack 5
    .limit locals 5
.line 227
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 1
    aload 1
    ldc "dic1"
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 2
    aload 2
    ldc "one"
    bipush 1
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 2
    ldc "two"
    bipush 2
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 2
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 1
    ldc "dic2"
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 3
    aload 3
    ldc "three"
    bipush 3
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 3
    ldc "four"
    bipush 4
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 3
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
.line 228
    aload 1
    astore 4
.line 229
    aload 4
    areturn
.end method

.method public not()V
    .limit stack 1
    .limit locals 1
.line 233
    aload_0
    invokevirtual HOME/not2()Ljava/lang/String;
    pop
    return
.end method

.method public not2()Ljava/lang/String;
    .limit stack 3
    .limit locals 1
.line 238
    aload_0
    invokevirtual HOME/hej()Ljava/lang/String;
    dup
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    areturn
.end method

.method public testtt()V
    .limit stack 2
    .limit locals 2
.line 242
    iconst_0
    istore 1
.line 243
    Label48:
    iload 1
    iconst_1
    if_icmpeq Label49
.line 244
    iload 1
    iconst_0
    if_icmpne Label50
    iconst_1
    goto Label51
    Label50:
    iconst_0
    Label51:
    istore 1
    goto Label48
    Label49:
    return
.end method

.method public PrintI(I)I
    .limit stack 3
    .limit locals 2
.line 249
    iload 1
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 1
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
.end method

.method public PrintD(D)D
    .limit stack 5
    .limit locals 3
.line 253
    dload 1
    getstatic java/lang/System/out Ljava/io/PrintStream;
    dload 1
    invokevirtual java/io/PrintStream/println(D)V
    dreturn
.end method

.method public PrintS(Ljava/lang/String;)Ljava/lang/String;
    .limit stack 3
    .limit locals 2
.line 257
    aload 1
    dup
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    areturn
.end method


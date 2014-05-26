.source                  HOME.java
.class                   public HOME
.super                   java/lang/Object
.field public TESTER LHOME/classes/standard/Input;
.field public TESTER2 LHOME/classes/standard/Input;
.field public abe1 Ljava/util/ArrayList;
.field public abe2 Ljava/util/HashMap;
.field public listBool Ljava/util/ArrayList;
.field public t Ljava/lang/String;
.field public y Ljava/lang/Double;
.field public z Ljava/lang/Integer;
.method public <init>()V
    .limit stack 10
    .limit locals 22
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
    aload_0
    invokevirtual HOME/returnTest2()LHOME/classes/standard/Input;
    aload_0
    swap
    putfield HOME/TESTER2 LHOME/classes/standard/Input;
.line 3
    aload_0
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 3
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
    aload 3
    aload 4
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 5
    aload 5
    aload_0
    getfield HOME/TESTER LHOME/classes/standard/Input;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 5
    aload_0
    getfield HOME/TESTER2 LHOME/classes/standard/Input;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 3
    aload 5
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 3
    aload_0
    swap
    putfield HOME/abe1 Ljava/util/ArrayList;
.line 4
    aload_0
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 6
    aload 6
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
    aload 6
    ldc "dic1"
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 8
    aload 8
    ldc "dic1"
    aload_0
    getfield HOME/TESTER LHOME/classes/standard/Input;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 8
    ldc "dic2"
    aload_0
    getfield HOME/TESTER2 LHOME/classes/standard/Input;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 8
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 6
    aload_0
    swap
    putfield HOME/abe2 Ljava/util/HashMap;
.line 5
    aload_0
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 9
    aload 9
    iconst_1
    invokestatic java/lang/Boolean.valueOf(Z)Ljava/lang/Boolean;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 9
    iconst_0
    invokestatic java/lang/Boolean.valueOf(Z)Ljava/lang/Boolean;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 9
    iconst_1
    invokestatic java/lang/Boolean.valueOf(Z)Ljava/lang/Boolean;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 9
    iconst_1
    invokestatic java/lang/Boolean.valueOf(Z)Ljava/lang/Boolean;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 9
    aload_0
    swap
    putfield HOME/listBool Ljava/util/ArrayList;
.line 6
    aload_0
    ldc "hej"
    ldc " "
    astore 12
    astore 11
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder.<init>()V
    aload 11
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    aload 12
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder.toString()Ljava/lang/String;
    ldc "med"
    astore 14
    astore 13
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder.<init>()V
    aload 13
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    aload 14
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder.toString()Ljava/lang/String;
    ldc " "
    astore 16
    astore 15
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder.<init>()V
    aload 15
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    aload 16
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder.toString()Ljava/lang/String;
    ldc "dig"
    astore 18
    astore 17
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder.<init>()V
    aload 17
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    aload 18
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder.toString()Ljava/lang/String;
    aload_0
    swap
    putfield HOME/t Ljava/lang/String;
.line 8
    aload_0
    ldc2_w 24.3d
    dneg
    invokestatic java/lang/Double.valueOf(D)Ljava/lang/Double;
    aload_0
    swap
    putfield HOME/y Ljava/lang/Double;
.line 9
    aload_0
    bipush 3
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    aload_0
    swap
    putfield HOME/z Ljava/lang/Integer;
return
.end method

.method public Setup()V
    .limit stack 9
    .limit locals 31
.line 12
    aload_0
    getfield HOME/y Ljava/lang/Double;
    invokevirtual java/lang/Double.doubleValue()D
    dconst_1
    dadd
    invokestatic java/lang/Double.valueOf(D)Ljava/lang/Double;
    aload_0
    swap
    putfield HOME/y Ljava/lang/Double;
.line 13
    aload_0
    getfield HOME/z Ljava/lang/Integer;
    invokevirtual java/lang/Integer.intValue()I
    iconst_1
    iadd
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    aload_0
    swap
    putfield HOME/z Ljava/lang/Integer;
.line 14
    aload_0
    aload_0
    getfield HOME/y Ljava/lang/Double;
    invokevirtual java/lang/Double.doubleValue()D
    invokevirtual HOME/PrintD(D)D
    pop2
.line 15
    aload_0
    aload_0
    getfield HOME/z Ljava/lang/Integer;
    invokevirtual java/lang/Integer.intValue()I
    invokevirtual HOME/PrintI(I)I
    pop
.line 16
    aload_0
    getfield HOME/y Ljava/lang/Double;
    invokevirtual java/lang/Double.doubleValue()D
    dconst_1
    dsub
    invokestatic java/lang/Double.valueOf(D)Ljava/lang/Double;
    aload_0
    swap
    putfield HOME/y Ljava/lang/Double;
.line 17
    aload_0
    getfield HOME/z Ljava/lang/Integer;
    invokevirtual java/lang/Integer.intValue()I
    iconst_1
    isub
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    aload_0
    swap
    putfield HOME/z Ljava/lang/Integer;
.line 18
    aload_0
    aload_0
    getfield HOME/y Ljava/lang/Double;
    invokevirtual java/lang/Double.doubleValue()D
    invokevirtual HOME/PrintD(D)D
    pop2
.line 19
    aload_0
    aload_0
    getfield HOME/z Ljava/lang/Integer;
    invokevirtual java/lang/Integer.intValue()I
    invokevirtual HOME/PrintI(I)I
    pop
.line 21
    bipush 3
    istore 1
.line 23
    aload_0
    getfield HOME/t Ljava/lang/String;
    ldc " "
    astore 3
    astore 2
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder.<init>()V
    aload 2
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    aload 3
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder.toString()Ljava/lang/String;
    ldc "Master"
    astore 5
    astore 4
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder.<init>()V
    aload 4
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    aload 5
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder.toString()Ljava/lang/String;
    aload_0
    swap
    putfield HOME/t Ljava/lang/String;
.line 24
    aload_0
    aload_0
    getfield HOME/t Ljava/lang/String;
    invokevirtual HOME/PrintS(Ljava/lang/String;)Ljava/lang/String;
    pop
.line 30
    aload_0
    getfield HOME/abe1 Ljava/util/ArrayList;
    bipush 1
    invokevirtual java/util/ArrayList.get(I)Ljava/lang/Object;
    checkcast java/util/ArrayList
    bipush 0
    invokevirtual java/util/ArrayList.get(I)Ljava/lang/Object;
    checkcast HOME/classes/standard/Input
    astore 6
.line 31
    aload_0
    aload 6
    invokevirtual HOME/classes/standard/Input.getPort()I
    invokevirtual HOME/PrintI(I)I
    pop
.line 33
    aload_0
    getfield HOME/abe2 Ljava/util/HashMap;
    ldc "dic1"
    invokevirtual java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast java/util/HashMap
    ldc "dic2"
    invokevirtual java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast HOME/classes/standard/Input
    astore 6
.line 34
    aload_0
    aload 6
    invokevirtual HOME/classes/standard/Input.getPort()I
    invokevirtual HOME/PrintI(I)I
    pop
.line 40
    iload 1
    sipush 314
    if_icmpeq Label1
.line 42
    bipush 43
    iload 1
    if_icmpeq Label2
.line 45
    iload 1
    bipush 4
    iadd
    istore 1
    goto Label3
    Label1:
.line 41
    iload 1
    iconst_1
    iadd
    istore 1
    goto Label3
    Label2:
.line 43
    iload 1
    bipush 123
    iadd
    istore 1
    goto Label3
    Label3:
.line 48
    iconst_1
    istore 7
.line 49
    iload 7
    ifne Label4
.line 51
    iload 7
    ifne Label5
.line 54
    aload_0
    ldc "if(XXX) - Intet virker"
    invokevirtual HOME/PrintS(Ljava/lang/String;)Ljava/lang/String;
    pop
    goto Label6
    Label4:
.line 50
    aload_0
    ldc "if(XXX) - Virker"
    invokevirtual HOME/PrintS(Ljava/lang/String;)Ljava/lang/String;
    pop
    goto Label6
    Label5:
.line 52
    aload_0
    ldc "if(XXX) - Noget Virker"
    invokevirtual HOME/PrintS(Ljava/lang/String;)Ljava/lang/String;
    pop
    goto Label6
    Label6:
.line 57
    iload 1
    i2d
    ldc2_w 3.0d
    dcmpl
    ifeq Label7
    goto Label8
    Label7:
.line 58
    aload_0
    getfield HOME/y Ljava/lang/Double;
    invokevirtual java/lang/Double.doubleValue()D
    ldc2_w 3.d
    dcmpl
    iflt Label9
.line 61
    iload 1
    iconst_1
    isub
    istore 1
    goto Label10
    Label9:
.line 59
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
.line 65
    aload_0
    iload 1
    invokevirtual HOME/PrintI(I)I
    pop
.line 71
    goto Label12
    Label11:
.line 72
    iload 1
    iconst_1
    iadd
    istore 1
    Label12:
    iload 1
    sipush 300
    if_icmplt Label11
.line 75
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
.line 76
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
.line 79
    goto Label18
    Label17:
.line 80
    goto Label20
    Label19:
.line 81
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
    iload 1
    bipush 3
    if_icmpgt Label19
    Label18:
    aload_0
    getfield HOME/y Ljava/lang/Double;
    invokevirtual java/lang/Double.doubleValue()D
    ldc2_w 3.2d
    dcmpl
    iflt Label17
.line 91
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 8
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 9
    aload 9
    bipush 11
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 9
    bipush 22
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 9
    bipush 33
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 8
    aload 9
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 10
    aload 10
    bipush 44
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 10
    bipush 55
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 10
    bipush 66
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 8
    aload 10
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 11
    aload 11
    bipush 77
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 11
    bipush 88
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 11
    bipush 99
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 8
    aload 11
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
.line 93
    aload 8
    invokeinterface java/util/List/iterator()Ljava/util/Iterator; 1
    astore 12
    Label21:
    aload 12
    invokeinterface java/util/Iterator/hasNext()Z 1
    ifeq Label22
    aload 12
    invokeinterface java/util/Iterator/next()Ljava/lang/Object; 1
    checkcast java/util/ArrayList
    astore 13
.line 94
    aload 13
    invokeinterface java/util/List/iterator()Ljava/util/Iterator; 1
    astore 14
    Label23:
    aload 14
    invokeinterface java/util/Iterator/hasNext()Z 1
    ifeq Label24
    aload 14
    invokeinterface java/util/Iterator/next()Ljava/lang/Object; 1
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer.intValue()I
    istore 15
.line 95
    aload_0
    iload 15
    invokevirtual HOME/PrintI(I)I
    pop
    goto Label23
    Label24:
    goto Label21
    Label22:
.line 102
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 16
    aload 16
    ldc "dic1"
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 17
    aload 17
    ldc "one"
    bipush 1
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 17
    ldc "two"
    bipush 2
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 17
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 16
    ldc "dic2"
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 18
    aload 18
    ldc "three"
    bipush 3
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 18
    ldc "four"
    bipush 4
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 18
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
.line 104
    aload 16
    ldc "dic1"
    invokevirtual java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast java/util/HashMap
    ldc "two"
    aload 16
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
.line 105
    aload 16
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
.line 107
    aload 16
    ldc "dic1"
    invokevirtual java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast java/util/HashMap
    invokevirtual java/util/HashMap/values()Ljava/util/Collection;
    invokeinterface java/util/Collection/iterator()Ljava/util/Iterator; 1
    astore 19
    Label25:
    aload 19
    invokeinterface java/util/Iterator/hasNext()Z 1
    ifeq Label26
    aload 19
    invokeinterface java/util/Iterator/next()Ljava/lang/Object; 1
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer.intValue()I
    istore 20
.line 108
    aload_0
    iload 20
    invokevirtual HOME/PrintI(I)I
    pop
    goto Label25
    Label26:
.line 116
    bipush 3
    bipush 3
    bipush 3
    imul
    imul
    iload 1
    iadd
    istore 21
.line 117
    iconst_1
    iconst_0
    iconst_1
    istore 23
    ifne Label28
    iload 23
    ifne Label28
    iconst_0
    goto Label27
    Label28:
    iconst_1
    Label27:
    istore 24
    ifeq Label29
    iload 24
    ifeq Label29
    iconst_1
    goto Label30
    Label29:
    iconst_0
    Label30:
    istore 24
.line 118
    bipush 3
    bipush 3
    if_icmple Label31
    iconst_1
    goto Label32
    Label31:
    iconst_0
    Label32:
    iconst_1
    istore 26
    ifeq Label33
    iload 26
    ifeq Label33
    iconst_1
    goto Label34
    Label33:
    iconst_0
    Label34:
    istore 26
.line 119
    iconst_1
    iconst_0
    istore 28
    ifne Label36
    iload 28
    ifne Label36
    iconst_0
    goto Label35
    Label36:
    iconst_1
    Label35:
    istore 28
.line 120
    ldc "asdf"
    astore 29
.line 122
    aload_0
    aload 29
    invokevirtual HOME/PrintS(Ljava/lang/String;)Ljava/lang/String;
    pop
.line 128
    aload_0
    aload_0
    getfield HOME/TESTER LHOME/classes/standard/Input;
    invokevirtual HOME/classes/standard/Input.getPort()I
    invokevirtual HOME/PrintI(I)I
    pop
.line 136
    aload_0
    getfield HOME/TESTER2 LHOME/classes/standard/Input;
    astore 30
.line 138
    new HOME/classes/standard/Input
    dup
    bipush 42
    invokespecial HOME/classes/standard/Input.<init>(I)V
    astore 30
.line 139
    aload_0
    aload 30
    invokevirtual HOME/classes/standard/Input.getPort()I
    invokevirtual HOME/PrintI(I)I
    pop
.line 142
    aload_0
    invokevirtual HOME/returnForkTest1()I
    pop
.line 143
    aload_0
    invokevirtual HOME/returnForkTest2()I
    pop
.line 144
    aload_0
    invokevirtual HOME/returnForkTest3()I
    pop
.line 146
    aload_0
    invokevirtual HOME/hejz()Ljava/util/ArrayList;
    pop
    return
.end method

.method public returnTest2()LHOME/classes/standard/Input;
    .limit stack 3
    .limit locals 2
.line 150
    new HOME/classes/standard/Input
    dup
    sipush 333
    invokespecial HOME/classes/standard/Input.<init>(I)V
    astore 1
.line 151
    aload 1
    areturn
.end method

.method public returnForkTest1()I
    .limit stack 3
    .limit locals 1
.line 155
    bipush 3
    bipush 3
    if_icmpeq Label37
    goto Label38
    Label37:
.line 156
    bipush 5
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 5
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
    Label38:
.line 158
    bipush 3
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 3
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
.end method

.method public hej()Ljava/lang/String;
    .limit stack 3
    .limit locals 2
.line 162
    ldc "HEJ"
    astore 1
.line 163
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
.line 167
    bipush 3
    bipush 4
    if_icmpeq Label39
.line 169
    bipush 5
    bipush 6
    if_icmpeq Label40
.line 172
    bipush 8
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 8
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
    Label39:
.line 168
    bipush 6
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 6
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
    Label40:
.line 170
    bipush 7
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 7
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
.end method

.method public returnForkTest3()I
    .limit stack 3
    .limit locals 1
.line 177
    bipush 1
    bipush 2
    if_icmpeq Label42
    goto Label43
    Label42:
.line 178
    bipush 3
    bipush 4
    if_icmpeq Label44
    goto Label45
    Label44:
.line 179
    bipush 5
    bipush 6
    if_icmpeq Label46
    goto Label47
    Label46:
.line 180
    bipush 7
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 7
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
    Label47:
    goto Label45
    Label45:
    goto Label43
    Label43:
.line 184
    bipush 0
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc 0
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
.end method

.method public hejz()Ljava/util/ArrayList;
    .limit stack 2
    .limit locals 3
.line 188
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 1
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 2
    aload 2
    ldc "lol2"
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 1
    aload 2
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
.line 189
    aload 1
    areturn
.end method

.method public not()V
    .limit stack 1
    .limit locals 1
.line 193
    aload_0
    invokevirtual HOME/not2()Ljava/lang/String;
    pop
    return
.end method

.method public not2()Ljava/lang/String;
    .limit stack 3
    .limit locals 1
.line 198
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
.line 202
    iconst_0
    istore 1
.line 203
    Label48:
    iload 1
    iconst_1
    if_icmpeq Label49
.line 204
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
.line 209
    iload 1
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 1
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
.end method

.method public PrintD(D)D
    .limit stack 5
    .limit locals 3
.line 213
    dload 1
    getstatic java/lang/System/out Ljava/io/PrintStream;
    dload 1
    invokevirtual java/io/PrintStream/println(D)V
    dreturn
.end method

.method public PrintS(Ljava/lang/String;)Ljava/lang/String;
    .limit stack 3
    .limit locals 2
.line 217
    aload 1
    dup
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    areturn
.end method


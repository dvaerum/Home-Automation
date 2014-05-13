.source                  HOME.java
.class                   public HOME
.super                   java/lang/Object
.field public wat Ljava/util/ArrayList;
.method public <init>()V
    .limit stack 32
    .limit locals 4
    aload_0
    invokespecial java/lang/Object/<init>()V
    aload_0
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 1
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 2
    aload 2
    bipush 1
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 2
    bipush 2
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 2
    bipush 3
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 1
    aload 2
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 3
    aload 3
    bipush 7
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 3
    bipush 8
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 3
    bipush 9
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 1
    aload 3
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 1
    putfield HOME/wat Ljava/util/ArrayList;
return
.end method

.method public Setup()V
    .limit stack 32
    .limit locals 2
    aload_0
    getfield HOME/wat Ljava/util/ArrayList;
    bipush 1
    invokevirtual java/util/ArrayList.get(I)Ljava/lang/Object;
    checkcast java/util/ArrayList
    astore 1
    aload_0
    aload_0
    getfield HOME/wat Ljava/util/ArrayList;
    bipush 1
    invokevirtual java/util/ArrayList.get(I)Ljava/lang/Object;
    checkcast java/util/ArrayList
    bipush 1
    invokevirtual java/util/ArrayList.get(I)Ljava/lang/Object;
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer/intValue()I
    invokevirtual HOME/PrintInteger(I)I
    pop
    aload_0
    aload 1
    bipush 2
    invokevirtual java/util/ArrayList.get(I)Ljava/lang/Object;
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer/intValue()I
    invokevirtual HOME/PrintInteger(I)I
    pop
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "Great Success!!"
    invokevirtual java/io/PrintStream.println(Ljava/lang/String;)V
    return
.end method

.method public static main([Ljava/lang/String;)V
    .limit stack 32
    .limit locals 1
    new HOME
    dup
    invokespecial HOME/<init>()V
    invokespecial HOME/Setup()V
    return
.end method

.method public PrintString(Ljava/lang/String;)Ljava/lang/String;
    .limit stack 11
    .limit locals 2
    aload 1
    dup
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    areturn
.end method

.method public PrintInteger(I)I
    .limit stack 11
    .limit locals 2
    iload 1
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 1
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
.end method

.method public PrintDecimal(D)D
    .limit stack 11
    .limit locals 3
    dload 1
    getstatic java/lang/System/out Ljava/io/PrintStream;
    dload 1
    invokevirtual java/io/PrintStream/println(D)V
    dreturn
.end method

.method public PrintBoolean(Z)Z
    .limit stack 11
    .limit locals 2
    iload 1
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 1
    invokevirtual java/io/PrintStream/println(Z)V
    ireturn
.end method


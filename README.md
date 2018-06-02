# NotePad

## 笔记列表界面

笔记列表界面将所有的课堂笔记、读书笔记以及待办事项（Plan）从数据库中取出，以ListView的形式进行展示；其中显示的时间在保存时获取到系统的时间，系统时间在获取到时是自1970年1月1日0时起的毫秒数，需要将其转换为yyyy/MM/dd HH:mm:ss形式的字符串进行保存，在原有的数据库的基础上添加了一个表示时间的列。

![笔记列表界面](https://github.com/wstelly/NotePad/blob/master/img1.png)

## 笔记按标题搜索

笔记按标题进行搜索，使用的是SearchView，当期检测到有输入变化时，就从数据库中按照输入的笔记名称检索笔记，如果检索到笔记，则将检索到的结果适配到ListView中，当有同名的笔记时，会将同名笔记一起展示。

![笔记按标题搜索](https://github.com/wstelly/NotePad/blob/master/img19.png)

## 笔记导出

![笔记导出](https://github.com/wstelly/NotePad/blob/master/img18.png)![笔记导出](https://github.com/wstelly/NotePad/blob/master/img51.png)

## 笔记编辑界面

![笔记编辑界面](https://github.com/wstelly/NotePad/blob/master/img5.png)

### 课堂笔记保存           读书笔记保存

当笔记编辑完成后，用户可以选择Save as C note即保存为课堂笔记，选择Save as R note则保存为读书笔记，笔记在保存时会对当前笔记编辑的背景的颜色进行保存，在笔记分类展示页面，笔记的背景颜色将会按照保存的色值进行展示。

![笔记编辑界面](https://github.com/wstelly/NotePad/blob/master/img16.png)![笔记编辑界面](https://github.com/wstelly/NotePad/blob/master/img17.png)

### 待办事项（Plan）保存

用户的笔记编辑与待办事项（Plan）功能采用同一个编辑界面，用户在编辑完成后选择Save as Plan，即可保存当前编辑的待办事项。

![笔记编辑界面](https://github.com/wstelly/NotePad/blob/master/img15.png)

## 笔记背景颜色选择界面

笔记背景颜色选择功能，使用自定义Dialog，在自定义Dialog中展示不同的颜色，并对展示的颜色进行设置ClickListener，当某一颜色被点击后，当前笔记的背景颜色将会改变成所选择的笔记的颜色。

![笔记编辑界面](https://github.com/wstelly/NotePad/blob/master/img6.png)![笔记编辑界面](https://github.com/wstelly/NotePad/blob/master/img7.png)![笔记编辑界面](https://github.com/wstelly/NotePad/blob/master/img8.png)![笔记编辑界面](https://github.com/wstelly/NotePad/blob/master/img9.png)![笔记编辑界面](https://github.com/wstelly/NotePad/blob/master/img10.png)

## 笔记分类展示界面
### 课堂笔记

课堂笔记在展示的时候依旧采用的是ListView，但会通过笔记的Type，对所有笔记进行筛选，筛选出课堂笔记，并根据笔记保存时的背景颜色使得笔记显示为不同的颜色。

![笔记编辑界面](https://github.com/wstelly/NotePad/blob/master/img12.png)

### 读书笔记

通过笔记的Type，对所有笔记进行筛选，筛选出读书笔记，并根据笔记保存时的背景颜色使得笔记显示为不同的颜色。

![笔记编辑界面](https://github.com/wstelly/NotePad/blob/master/img13.png)

## 待办功能(Plan)

待办功能与课堂笔记以及读书笔记展示的形式相同，但其布局进行了调整，不经会显示待办事项的编辑时间，还会显示具体的内容。

![笔记编辑界面](https://github.com/wstelly/NotePad/blob/master/img14.png)




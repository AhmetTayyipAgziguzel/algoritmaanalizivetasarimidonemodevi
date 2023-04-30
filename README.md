# algoritmaanalizivetasarimidonemodevi

AKIŞ ŞEMASI

1.	Sabitler ve değişkenler tanımlanır.
    
    •	NUM_LOCATIONS
    
    •	COORDINATES
    
    •	PRIORITY_STOCK

2.	main () fonksiyonu başlar.

3.	createAdjacencyMatrix () fonksiyonu çağrılır ve adjacencyMatrix döndürülür.

4.	PRIORITY_STOCK üzerinde döngü başlatılır: a. Öncelik ve stok değerleri alınır. b. determineDistributionAmounts() fonksiyonu çağrılır ve distributionAmounts döndürülür. c. dijkstra() fonksiyonu çağrılır ve distributionOrder döndürülür. d. distributeItems() fonksiyonu çağrılır ve dağıtım işlemi gerçekleştirilir.

5.	createAdjacencyMatrix() fonksiyonu: a. Koordinatlara göre adjacency matrisi oluşturulur. b. Öklidyen mesafe kullanılarak iki nokta arasındaki mesafe hesaplanır. c. Matris döndürülür.

6.	determineDistributionAmounts() fonksiyonu: a. İhtiyaçların miktarını belirlemek için örnek fonksiyon. b. Her lokasyonun eşit miktarda ihtiyacı olduğu varsayılarak miktarlar döndürülür.

7.	dijkstra() fonksiyonu: a. Dijkstra algoritması kullanılarak en kısa yol bulunur. b. En kısa mesafeler ve parent düğümler döndürülür.

8.	createDistributionOrder() fonksiyonu: a. Dijkstra algoritması sonucuna göre dağıtım sırası oluşturulur. b. Dağıtım sırası listesi döndürülür.

9.	distributeItems() fonksiyonu: a. Öğelerin dağıtımı gerçekleştirilir ve kalan stok güncellenir. b. Dağıtım işlemi sırasında her adımda öncelik, lokasyon ve dağıtılan miktar yazdırılır.

10.	main() fonksiyonu sona erer.


GRAF TEORİSİ VE ALGORİTMALARI HAKKINDA GENEL BİLGİ

Graf teorisi, matematik ve bilgisayar bilimlerinde kullanılan, nesneler arasındaki ilişkileri inceleyen bir alanıdır. Graf teorisi, düğümler (veya köşeler) ve bu düğümleri birbirine bağlayan kenarlar (veya bağlantılar) adı verilen iki temel bileşen arasındaki ilişkileri inceler.
Graf teorisi ve algoritmaları birçok gerçek dünya problemini modellemeye ve çözmeye yardımcı olur. İşte graf teorisi ve algoritmalarıyla ilgili bazı temel kavramlar ve algoritmalar:

1.	Temel kavramlar:
    
    •	Düğüm (Node) veya köşe (Vertex): Grafin temel birimi.
    
    •	Kenar (Edge): İki düğüm arasındaki bağlantı.
    
    •	Derece (Degree): Bir düğüme bağlı olan kenarların sayısı.
    
    •	Ağırlıklı graf (Weighted graph): Kenarlara ağırlıklar atanmış graf.
    
    •	Yönlü graf (Directed graph): Kenarların yönlendirildiği graf.
    
    •	Yönsüz graf (Undirected graph): Kenarların yönlendirilmemiş olduğu graf.
    
    •	Komşu (Neighbor): Bir düğüme bağlı olan diğer düğümler.
    
    •	Yol (Path): İki düğüm arasındaki kenarlar dizisi.
    
    •	Döngü (Cycle): Başlangıç ve bitiş düğümü aynı olan yol.
    
    •	Bağlantılı graf (Connected graph): Her düğüm çifti arasında en az bir yol olan graf.
    
    •	Ağaç (Tree): Döngüsüz ve bağlantılı graf.

2.	Önemli algoritmalar:
    
    •	Derinlik İlk Arama (DFS, Depth-First Search): Bir grafı ziyaret etme ve dolaşma yöntemi. DFS, ziyaret edilen düğümün tüm komşularını ziyaret etmeden önce daha derin düğümleri ziyaret eder.
    
    •	Genişlik İlk Arama (BFS, Breadth-First Search): Bir grafı ziyaret etme ve dolaşma yöntemi. BFS, ziyaret edilen düğümün tüm komşularını ziyaret ettikten sonra daha derin düğümlere geçer.
    
    •	Dijkstra'nın algoritması: Ağırlıklı, yönlü veya yönsüz graf üzerinde, belirli bir düğümden diğer düğümlere en kısa yolu bulan bir algoritmadır.
    
    •	Bellman-Ford algoritması: Ağırlıklı, yönlü graf üzerinde, belirli bir düğümden diğer düğümlere en kısa yolu bulan bir algoritmadır. Dijkstra'nın algoritmasından farklı olarak, negatif ağırlıklı kenarlarla başa çıkabilir.
    
    •	Kruskal algoritması: Ağırlıklı, yönsüz graf üzerinde minimum kapsayıcı ağaç (Minimum Spanning Tree, MST) bulan bir algoritmadır. MST, grafin tüm düğümlerini birbirine bağlayan ve toplam kenar ağırlıklarının minimum olduğu bir ağaçtır.
    
    •	Prim algoritması: Ağırlıklı, yönsüz graf üzerinde minimum kapsayıcı ağaç (MST) bulan bir diğer algoritmadır. Kruskal algoritmasından farklı olarak, Prim algoritması "aç gözlü" bir yaklaşımla çalışır ve her adımda en düşük ağırlıklı kenarı ekleyerek MST'yi büyütür.
    
    •	Floyd-Warshall algoritması: Ağırlıklı, yönlü graf üzerinde, tüm düğüm çiftleri arasındaki en kısa yolları bulan bir algoritmadır. Bu algoritma, negatif ağırlıklı kenarlarla başa çıkabilir, ancak negatif döngülerle başa çıkamaz.
    
    •	Ford-Fulkerson algoritması: Ağırlıklı, yönlü graf üzerinde, maksimum akış problemini çözmeye yarayan bir algoritmadır. Maksimum akış problemi, bir kaynak düğümden bir hedef düğüme olan maksimum akış miktarını belirlemeyi amaçlar.
    
    •	Topolojik sıralama: Yönlü ve döngüsüz graf (DAG) üzerinde, düğümlerin bir sıralamasını belirleyen bir algoritmadır. Bu sıralamada, her yönlü kenarın (u, v) başlangıç düğümü u, bitiş düğümü v'den önce gelmelidir.
    
    •	Graf teorisi ve algoritmaları, birçok uygulama alanında kullanılabilir, örneğin; sosyal ağ analizi, iletişim ağları, biyoinformatik, yol planlama, optimizasyon ve daha pek çok alanda. Bu algoritmalar, gerçek dünya problemlerinin analizi ve çözümü için önemli araçlar sunar.


DİJKSTRA ALGORİTMASI HAKKINDA TEKNİK İÇERİK

Dijkstra algoritması, Edsger W. Dijkstra tarafından 1956'da icat edilen ve graf teorisi alanında yaygın olarak kullanılan bir en kısa yol algoritmasıdır. Bu algoritma, ağırlıklı bir grafın (özellikle yönetsel ağırlıklı) iki düğümü arasındaki en kısa yolun uzunluğunu ve yolun kendisini hesaplamak için kullanılır. Algoritma, negatif ağırlıklı kenarlar içermeyen grafikler için uygundur.

Dijkstra algoritması aşağıdaki adımları izler:

    1.	Başlangıç düğümünü seçin (s) ve hedef düğümü (t) belirleyin.
    
    2.	Başlangıç düğümünün ağırlığını 0 olarak, diğer tüm düğümlerin ağırlığını ise sonsuz (∞) olarak atayın.
    
    3.	Başlangıç düğümünü ziyaret edilmemiş düğümler kümesine ekleyin.
    
    4.	Ziyaret edilmemiş düğümler kümesindeki en düşük ağırlıklı düğümü seçin ve bu düğümü ziyaret edin.
    
    5.	Şu anki düğümden bağlantılı tüm komşu düğümleri kontrol edin. Eğer yeni ağırlık (şu anki düğümün ağırlığı + kenarın ağırlığı) 
    mevcut ağırlıktan düşükse, bu komşu düğümün ağırlığını yeni ağırlık değeriyle güncelleyin.
    
    6.	Şu anki düğümü ziyaret edilmiş olarak işaretleyin ve ziyaret edilmemiş düğümler kümesinden çıkarın.
    
    
    7.	Hedef düğüm ziyaret edilene kadar veya ziyaret edilmemiş düğümler kümesi boşalana kadar adımları 4-6'yı tekrarlayın.
    
    8.	Hedef düğümün ağırlığı, başlangıç düğümünden hedef düğüme kadar olan en kısa yolun uzunluğunu gösterir. 
    Bu yolun kendisini elde etmek için, hedef düğümden başlayarak önceki düğümleri takip edin ve başlangıç düğümüne ulaşana kadar geriye 
    doğru gidin.

Dijkstra algoritması, en kısa yol problemlerini çözmek için güvenilir ve etkili bir yöntemdir. Algoritmanın çalışma zamanı, grafın düğüm ve 
kenar sayısına bağlı olarak O(|V|^2) (V: düğüm sayısı) olabilir; ancak öncelik kuyruğu kullanarak bu süre O(|E|+|V|log|V|) (E: kenar sayısı) 
olarak optimize edilebilir.





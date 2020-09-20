package com.example.newsapi.server

import android.util.Log
import com.example.newsapi.utils.FileUtils
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import java.net.HttpURLConnection

class MyMockServer {

    class SuccessRequestDispatcher:Dispatcher() {
        override fun dispatch(request: RecordedRequest?): MockResponse {
            return MockResponse().setResponseCode(200).setBody(
                "{\n" +
                        "\t\"status\": \"ok\",\n" +
                        "\t\"totalResults\": 10,\n" +
                        "\t\"articles\": [{\n" +
                        "\t\t\t\"source\": {\n" +
                        "\t\t\t\t\"id\": \"techcrunch\",\n" +
                        "\t\t\t\t\"name\": \"TechCrunch\"\n" +
                        "\t\t\t},\n" +
                        "\t\t\t\"author\": \"Ron Miller\",\n" +
                        "\t\t\t\"title\": \"SaaS Ventures takes the investment road less traveled\",\n" +
                        "\t\t\t\"description\": \"Most venture capital firms are based in hubs like Silicon Valley, New York City and Boston. These firms nurture those ecosystems and they’ve done well, but SaaS Ventures decided to go a different route: it went to cities like Chicago, Green Bay, Wisconsin and…\",\n" +
                        "\t\t\t\"url\": \"https://techcrunch.com/2020/09/18/saas-ventures-takes-the-investment-road-less-traveled/\",\n" +
                        "\t\t\t\"urlToImage\": \"https://techcrunch.com/wp-content/uploads/2020/09/GettyImages-1057338140.jpg?w=604\",\n" +
                        "\t\t\t\"publishedAt\": \"2020-09-18T21:15:47Z\",\n" +
                        "\t\t\t\"content\": \"Most venture capital firms are based in hubs like Silicon Valley, New York City and Boston. These firms nurture those ecosystems and they’ve done well, but SaaS Ventures decided to go a different rou… [+2421 chars]\"\n" +
                        "\t\t},\n" +
                        "\t\t{\n" +
                        "\t\t\t\"source\": {\n" +
                        "\t\t\t\t\"id\": \"techcrunch\",\n" +
                        "\t\t\t\t\"name\": \"TechCrunch\"\n" +
                        "\t\t\t},\n" +
                        "\t\t\t\"author\": \"Jonathan Shieber\",\n" +
                        "\t\t\t\"title\": \"Gaming companies are reportedly the next targets in the US government's Tencent purge\",\n" +
                        "\t\t\t\"description\": \"Some of the biggest names in online gaming in the United States have received letters from the U.S. government requesting information about their relationship with the multibillion-dollar Chinese technology company, Tencent, according to reports. Even as the …\",\n" +
                        "\t\t\t\"url\": \"https://techcrunch.com/2020/09/18/gaming-companies-are-reportedly-the-next-targets-in-the-us-governments-tencent-purge/\",\n" +
                        "\t\t\t\"urlToImage\": \"https://techcrunch.com/wp-content/uploads/2020/08/EfUzYOTUYAU3R-g.jpeg?w=711\",\n" +
                        "\t\t\t\"publishedAt\": \"2020-09-18T21:04:59Z\",\n" +
                        "\t\t\t\"content\": \"Some of the biggest names in online gaming in the United States have received letters from the U.S. government requesting information about their relationship with the multibillion-dollar Chinese tec… [+4181 chars]\"\n" +
                        "\t\t},\n" +
                        "\t\t{\n" +
                        "\t\t\t\"source\": {\n" +
                        "\t\t\t\t\"id\": \"techcrunch\",\n" +
                        "\t\t\t\t\"name\": \"TechCrunch\"\n" +
                        "\t\t\t},\n" +
                        "\t\t\t\"author\": \"Jordan Crook\",\n" +
                        "\t\t\t\"title\": \"Check out this never-before-seen clip from HBO's The Perfect Weapon\",\n" +
                        "\t\t\t\"description\": \"At Disrupt 2020, we got a chance to see some never-before-seen footage from HBO’s upcoming documentary The Perfect Weapon. The documentary, which was executive produced by John Maggio, is based on the book by the same(ish) name written by David Sanger, Washin…\",\n" +
                        "\t\t\t\"url\": \"https://techcrunch.com/2020/09/18/check-out-this-never-before-seen-clip-from-hbos-the-perfect-weapon/\",\n" +
                        "\t\t\t\"urlToImage\": \"https://techcrunch.com/wp-content/uploads/2020/09/Screen-Shot-2020-09-18-at-1.27.40-PM.png?w=550\",\n" +
                        "\t\t\t\"publishedAt\": \"2020-09-18T20:36:18Z\",\n" +
                        "\t\t\t\"content\": \"At Disrupt 2020, we got a chance to see some never-before-seen footage from HBO’s upcoming documentary The Perfect Weapon.\\r\\nThe documentary, which was executive produced by John Maggio, is based on t… [+583 chars]\"\n" +
                        "\t\t},\n" +
                        "\t\t{\n" +
                        "\t\t\t\"source\": {\n" +
                        "\t\t\t\t\"id\": \"techcrunch\",\n" +
                        "\t\t\t\t\"name\": \"TechCrunch\"\n" +
                        "\t\t\t},\n" +
                        "\t\t\t\"author\": \"Ron Miller\",\n" +
                        "\t\t\t\"title\": \"Salesforce announces 12,000 new jobs in the next year just weeks after laying off 1000\",\n" +
                        "\t\t\t\"description\": \"In a case of bizarre timing, Salesforce announced it was laying off 1000 employees at the end of last month just a day after announcing a monster quarter with over \$5 billion in revenue, putting the company on a \$20 billion revenue run rate for the first time…\",\n" +
                        "\t\t\t\"url\": \"https://techcrunch.com/2020/09/18/salesforce-announces-12000-new-jobs-in-the-next-year-just-weeks-after-laying-off-1000/\",\n" +
                        "\t\t\t\"urlToImage\": \"https://techcrunch.com/wp-content/uploads/2019/05/Salesforce-logos.jpg?w=493\",\n" +
                        "\t\t\t\"publishedAt\": \"2020-09-18T20:14:39Z\",\n" +
                        "\t\t\t\"content\": \"In a case of bizarre timing, Salesforce announced it was laying off 1000 employees at the end of last month just a day after announcing a monster quarter with over \$5 billion in revenue, putting the … [+1409 chars]\"\n" +
                        "\t\t},\n" +
                        "\t\t{\n" +
                        "\t\t\t\"source\": {\n" +
                        "\t\t\t\t\"id\": \"techcrunch\",\n" +
                        "\t\t\t\t\"name\": \"TechCrunch\"\n" +
                        "\t\t\t},\n" +
                        "\t\t\t\"author\": \"Lucas Matney\",\n" +
                        "\t\t\t\"title\": \"And the winner of Startup Battlefield at Disrupt 2020 is… Canix\",\n" +
                        "\t\t\t\"description\": \"We started this competition with 20 impressive startups. After four days of fierce pitching in a wholly new virtual Startup Battlefield arena, we have a winner. The startups taking part in the Startup Battlefield have all been hand-picked to participate in ou…\",\n" +
                        "\t\t\t\"url\": \"https://techcrunch.com/2020/09/18/and-the-winner-of-startup-battlefield-at-disrupt-2020-is-canix/\",\n" +
                        "\t\t\t\"urlToImage\": \"https://techcrunch.com/wp-content/uploads/2020/09/Screen-Shot-2020-09-18-at-1.01.29-PM.jpg?w=701\",\n" +
                        "\t\t\t\"publishedAt\": \"2020-09-18T20:02:26Z\",\n" +
                        "\t\t\t\"content\": \"We started this competition with 20 impressive startups. After four days of fierce pitching in a wholly new virtual Startup Battlefield arena, we have a winner.\\r\\nThe startups taking part in the Start… [+1626 chars]\"\n" +
                        "\t\t},\n" +
                        "\t\t{\n" +
                        "\t\t\t\"source\": {\n" +
                        "\t\t\t\t\"id\": \"techcrunch\",\n" +
                        "\t\t\t\t\"name\": \"TechCrunch\"\n" +
                        "\t\t\t},\n" +
                        "\t\t\t\"author\": \"Jacob Eiting\",\n" +
                        "\t\t\t\"title\": \"Are high churn rates depressing earnings for app developers?\",\n" +
                        "\t\t\t\"description\": \"It’s great to improve your subscription app’s retention rates, but don’t do it for the 85/15 split.\",\n" +
                        "\t\t\t\"url\": \"https://techcrunch.com/2020/09/18/are-high-churn-rates-depressing-earnings-for-app-developers/\",\n" +
                        "\t\t\t\"urlToImage\": \"https://techcrunch.com/wp-content/uploads/2020/09/GettyImages-887922-001.jpg?w=544\",\n" +
                        "\t\t\t\"publishedAt\": \"2020-09-18T19:16:36Z\",\n" +
                        "\t\t\t\"content\": \"Ever since Apple opened up subscription monetization to more apps in 2016 and enticed developers with an 85/15 split on revenue from customers that remain subscribed for more than a year subscription… [+1656 chars]\"\n" +
                        "\t\t},\n" +
                        "\t\t{\n" +
                        "\t\t\t\"source\": {\n" +
                        "\t\t\t\t\"id\": \"techcrunch\",\n" +
                        "\t\t\t\t\"name\": \"TechCrunch\"\n" +
                        "\t\t\t},\n" +
                        "\t\t\t\"author\": \"Darrell Etherington\",\n" +
                        "\t\t\t\"title\": \"MIT engineers develop a totally flat fisheye lens that could make wide-angle cameras easier to produce\",\n" +
                        "\t\t\t\"description\": \"Engineers at MIT, in partnership with the University of Massachusetts at Lowell, have devised a way to build a camera lens that avoids the typical spherical curve of ultra-wide-angle glass, while still providing true optical fisheye distortion. The fisheye le…\",\n" +
                        "\t\t\t\"url\": \"https://techcrunch.com/2020/09/18/mit-engineers-develop-a-totally-flat-fisheye-lens-that-could-make-wide-angle-cameras-easier-to-produce/\",\n" +
                        "\t\t\t\"urlToImage\": \"https://techcrunch.com/wp-content/uploads/2020/09/MIT-Fisheye-Lens-01_0.jpg?w=600\",\n" +
                        "\t\t\t\"publishedAt\": \"2020-09-18T19:14:47Z\",\n" +
                        "\t\t\t\"content\": \"Engineers at MIT, in partnership with the University of Massachusetts at Lowell, have devised a way to build a camera lens that avoids the typical spherical curve of ultra-wide-angle glass, while sti… [+1965 chars]\"\n" +
                        "\t\t},\n" +
                        "\t\t{\n" +
                        "\t\t\t\"source\": {\n" +
                        "\t\t\t\t\"id\": \"techcrunch\",\n" +
                        "\t\t\t\t\"name\": \"TechCrunch\"\n" +
                        "\t\t\t},\n" +
                        "\t\t\t\"author\": \"Kirsten Korosec\",\n" +
                        "\t\t\t\"title\": \"Battery tech superstars JB Straubel of Redwood Materials, Celina Mikolajczak of Panasonic coming to TC Mobility 2020\",\n" +
                        "\t\t\t\"description\": \"It was a trickle at first that has evolved into a slow and steady stream. Now, a wave of new electric vehicles is building, promising to deliver an unprecedented number of models to North America, Europe and China over the next two to three years. There might…\",\n" +
                        "\t\t\t\"url\": \"https://techcrunch.com/2020/09/18/battery-tech-superstars-jb-straubel-of-redwood-materials-celina-mikolajczak-of-panasonic-coming-to-tc-mobility-2020/\",\n" +
                        "\t\t\t\"urlToImage\": \"https://techcrunch.com/wp-content/uploads/2020/09/Straubel-Mikolajczak.jpg?w=711\",\n" +
                        "\t\t\t\"publishedAt\": \"2020-09-18T18:15:34Z\",\n" +
                        "\t\t\t\"content\": \"It was a trickle at first that has evolved into a slow and steady stream. Now, a wave of new electric vehicles is building, promising to deliver an unprecedented number of models to North America, Eu… [+3358 chars]\"\n" +
                        "\t\t},\n" +
                        "\t\t{\n" +
                        "\t\t\t\"source\": {\n" +
                        "\t\t\t\t\"id\": \"techcrunch\",\n" +
                        "\t\t\t\t\"name\": \"TechCrunch\"\n" +
                        "\t\t\t},\n" +
                        "\t\t\t\"author\": \"Kirsten Korosec\",\n" +
                        "\t\t\t\"title\": \"Zoox becomes fourth company to land driverless testing permit in California\",\n" +
                        "\t\t\t\"description\": \"Zoox, the automated vehicle technology startup that was acquired by Amazon this year, has been issued a permit from California regulators that will allow it to test driverless vehicles on public roads. The permit is not for all public roads in the state, but …\",\n" +
                        "\t\t\t\"url\": \"https://techcrunch.com/2020/09/18/zoox-becomes-fourth-company-to-land-driverless-testing-permit-in-california/\",\n" +
                        "\t\t\t\"urlToImage\": \"https://techcrunch.com/wp-content/uploads/2019/10/aicha-evans-zoox-DSC03535-1.jpg?w=600\",\n" +
                        "\t\t\t\"publishedAt\": \"2020-09-18T17:31:59Z\",\n" +
                        "\t\t\t\"content\": \"Zoox, the automated vehicle technology startup that was acquired by Amazon this year, has been issued a permit from California regulators that will allow it to test driverless vehicles on public road… [+2564 chars]\"\n" +
                        "\t\t},\n" +
                        "\t\t{\n" +
                        "\t\t\t\"source\": {\n" +
                        "\t\t\t\t\"id\": \"techcrunch\",\n" +
                        "\t\t\t\t\"name\": \"TechCrunch\"\n" +
                        "\t\t\t},\n" +
                        "\t\t\t\"author\": \"Jonathan Shieber\",\n" +
                        "\t\t\t\"title\": \"Amid layoffs and allegations of fraud, the FBI has arrested NS8's CEO following its \$100+ million summer financing\",\n" +
                        "\t\t\t\"description\": \"The tagline from today’s announcement from the United States Attorney’s office for the Southern District of New York says it all: “Adam Rogas Allegedly Raised \$123 Million from Investors Using Financial Statements that Showed Tens of Millions of Dollars of Re…\",\n" +
                        "\t\t\t\"url\": \"https://techcrunch.com/2020/09/18/amid-layoffs-and-allegations-of-fraud-the-fbi-has-arrested-ns8s-ceo-following-its-100-million-summer-financing/\",\n" +
                        "\t\t\t\"urlToImage\": \"https://techcrunch.com/wp-content/uploads/2014/01/us-doj.jpg?w=533\",\n" +
                        "\t\t\t\"publishedAt\": \"2020-09-18T17:29:36Z\",\n" +
                        "\t\t\t\"content\": \"The tagline from today’s announcement from the United States Attorney’s office for the Southern District of New York says it all: “Adam Rogas Allegedly Raised \$123 Million from Investors Using Financ… [+3278 chars]\"\n" +
                        "\t\t}\n" +
                        "\t]\n" +
                        "}"
            )
        }
    }

    class ErrorDispatcher: Dispatcher(){
        override fun dispatch(request: RecordedRequest): MockResponse {
            return MockResponse().setResponseCode(400)
        }

    }
}


import okhttp3.OkHttpClient

object ConnectionClient {
    val client = OkHttpClient().newBuilder()
        .build()
    val authcode="eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJodHRwczovL3Rlc3Rib29rLmNvbSIsInN1YiI6" +
            "IjViZjJlMTQzNWM4ZmI4MGNjNTE4ZmY4YSIsImF1ZCI6IlRCIiwiZXhwIjoiMjAyMS0wMS0wOFQxNjowODo1Mi4wMzIyND" +
            "Q3NTlaIiwiaWF0IjoiMjAyMC0xMi0wOVQxNjowODo1Mi4wMzIyNDQ3NTlaIiwibmFtZSI6Ik1lZ2hkdXQgTWFuZGFsIiwiZW1" +
            "haWwiOiJtZWdoZHV0LndpbmRvd3NAZ21haWwuY29tIiwib3JnSWQiOiIiLCJpc0xNU1VzZXIiOmZhbHNlLCJyb2xlcy" +
            "I6InN0dWRlbnQifQ.TZbwXMdx4flk2v5ekZFSuzEBkKTsu4x3ll6hYUyv6UdrI0grvGWZG2yOcpKpmXxtWnwU46uA1gUI" +
            "H4HVLcEkKtYz9Ply0TrZGXf511gCNvqgN1baTEe3d3-Sg1aUHDFWgYz6sHHzUF-lfQiVNs69nlJmneTOB3u65uckKbe2764"
}